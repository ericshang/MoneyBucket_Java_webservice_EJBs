/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Account;
import Entities.Transaction;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eric
 */
public class ShowAllTransaction extends HttpServlet {


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
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        if(session==null || session.getAttribute("Account") ==null){//user not logged in yet
            //jump to login page
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }else{
            Account account = (Account)session.getAttribute("Account");
            ArrayList<Transaction> transactions  = account.getTransactions();
            
            String transactionListHtml = "";
            
            for(Transaction t: transactions){
                transactionListHtml += "<p>Amount:"+t.getAmount()+"<br /> Note:"+t.getNote()+"</p>";
            }        
            transactionListHtml += "<p> Total balance: "+account.getBanlance()+"</p>";
            request.setAttribute("transactionListHtml", transactionListHtml);
            // put client name into a bean
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showalltransaction.jsp");
            dispatcher.forward(request, response);
        }
        
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

}
