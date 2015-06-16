/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import WebServiceClient.InterestRate;
import WebServiceClient.InterestRateWS_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class InterestRateServlet extends HttpServlet {
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
        String InterestListHtml = "";
        String act = request.getParameter("act");
        ArrayList<InterestRate> list;
        if(act!=null && act.equalsIgnoreCase("showDeposit")){
            list = (ArrayList<InterestRate>)getSavingRateList();            
        }else if ( act!=null &&  act.equalsIgnoreCase("showBorrow")){
            list = (ArrayList<InterestRate>)getBorrowRateList();
        }else{//show all
            list = (ArrayList<InterestRate>)getAllInterestRateList();
        }
        
        for(int i=0; i < list.size();i++){
            InterestRate rate = list.get(i);
            InterestListHtml +="<p>Type: "+rate.getType()+
                        " Month:"+rate.getMonth()+
                        " Interest Rate: "+rate.getRate()+"</p>";
        }
        
        request.setAttribute("InterestListHtml", InterestListHtml);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/interestRate.jsp");
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
            throws ServletException, IOException {
        doGet(request, response);
    }

    private java.util.List<WebServiceClient.InterestRate> getAllInterestRateList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebServiceClient.InterestRateWS port = service.getInterestRateWSPort();
        return port.getAllInterestRateList();
    }

    private java.util.List<WebServiceClient.InterestRate> getBorrowRateList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebServiceClient.InterestRateWS port = service.getInterestRateWSPort();
        return port.getBorrowRateList();
    }

    private java.util.List<WebServiceClient.InterestRate> getSavingRateList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebServiceClient.InterestRateWS port = service.getInterestRateWSPort();
        return port.getSavingRateList();
    }

}
