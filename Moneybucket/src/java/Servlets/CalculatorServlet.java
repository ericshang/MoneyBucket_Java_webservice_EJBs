/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import WebServiceClient.InterestRate;
import WebServiceClient.InterestRateWS_Service;
import WebServiceClient.RateType;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Eric
 */
public class CalculatorServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/InterestRateWebService/InterestRateWS.wsdl")
    private InterestRateWS_Service service;

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/calculator.jsp");
            dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String calculationHtml = "";
        
        int type = Integer.parseInt(request.getParameter("type"));
        int month = Integer.parseInt(request.getParameter("month"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        if(month<1 || amount <=0){
            doGet(request,response);
        }else{
            InterestRate ir = null;
            //get the interest rate from web service
            RateType rateType;
            if(type ==1 ){//borrow
                ir = getBorrowInterestRateByMonth(month);
                rateType = RateType.BORROW;
            }else{//saving
                ir = getSavingInterestRateByMonth(month);
                rateType = RateType.SAVING;
            }
            double rate = ir.getRate() /12; //convert it to monthly rate, for calculation purpose
            
            double totalInterest = amount * month * rate;
            double totalDue = amount + totalInterest;
            calculationHtml = "<p>"
                    + "Type: "+rateType
                    + "<br /> Interest Rate: "+ amount 
                    + "<br /> Initial Amount: "+ ir.getRate() 
                    + "<br /> Total Interest: "+ totalInterest
                    + "<br /> Amount in Total: "+ totalDue
                    + "</p>";
            
            
        }
        request.setAttribute("calculationHtml", calculationHtml);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/calculator.jsp");
            dispatcher.forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private InterestRate getBorrowInterestRateByMonth(int month) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebServiceClient.InterestRateWS port = service.getInterestRateWSPort();
        return port.getBorrowInterestRateByMonth(month);
    }

    private InterestRate getSavingInterestRateByMonth(int month) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebServiceClient.InterestRateWS port = service.getInterestRateWSPort();
        return port.getSavingInterestRateByMonth(month);
    }

}
