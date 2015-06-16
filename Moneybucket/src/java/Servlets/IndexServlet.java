/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import EJBs.AccountSessionBeanLocal;
import Entities.Account;
import Entities.Transaction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shang
 */
public class IndexServlet extends HttpServlet {
    @EJB
    private AccountSessionBeanLocal accountSessionBean;

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
        
        if(session==null || session.getAttribute("Account") ==null){
            //jump to login page
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }else{
            //take account information out of session
            Account account = (Account)session.getAttribute("Account");

            String Accountname = account.getUsername();
            double accountBalance = account.getBanlance();
            //calculate of last 30 days
            double incomeInPast30Days =0;// in '10.0002'format
            double spendingInPast30Days =0;// in '-10.002' format
            double periodBalanceOfLast30Days = 0;
            
            ArrayList<Transaction> transactions = account.getTransactions();//all transactions
            Date now = new Date();       
            long timestampFloor = now.getTime() - 30*24*60*60*1000;//in the past 30 days in mil seconds
            
            for(Transaction t : transactions){
                if(t.getTime() > timestampFloor ){
                    double tAmount = t.getAmount();
                    if(tAmount>=0){
                        incomeInPast30Days += tAmount;
                    }else{
                        spendingInPast30Days += tAmount;
                    }
                }
            }
            periodBalanceOfLast30Days = incomeInPast30Days + spendingInPast30Days;
            
            String AccountOverviewHtml = "<li>Account: <span>"+Accountname+"</span></li>\n" +
                "<li>Current Ballance: <span>"+accountBalance+"</span></li>\n" ;
            
            request.setAttribute("AccountOverviewHtml", AccountOverviewHtml);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
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
