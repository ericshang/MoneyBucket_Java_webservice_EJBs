/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import EJBs.AccountSessionBeanLocal;
import EJBs.TransactionSessionBeanLocal;
import Entities.Account;
import Entities.Transaction;
import java.io.IOException;
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
public class AddTransactionServlet extends HttpServlet {
    @EJB
    private AccountSessionBeanLocal accountSessionBean;
    @EJB
    private TransactionSessionBeanLocal transactionSessionBean;

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
        String act = request.getParameter("act");
      
        if (act!=null && act.equalsIgnoreCase("doAddTransaction")){// show page with form to obtain client name
            doPost(request, response);
        }else{// put client name into a bean
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addtransaction.jsp");
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
         HttpSession session = request.getSession(false);
        
        if(session==null || session.getAttribute("Account") ==null){//user not logged in yet
            //jump to login page
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }else{
            Account account = (Account)session.getAttribute("Account");
            int aid = account.getAid();
            int transactiontype = Integer.parseInt(request.getParameter("transactiontype"));//-1 withdraw, 1 deposit
            double amount = Double.parseDouble(request.getParameter("amount"));
            amount = transactiontype>0 ? amount : 0-amount;
            String note = request.getParameter("note");
            String rs ="add transaction result:"; 
            if(aid<1 || amount ==0){
                rs += " Failed!";
            }else{
                Transaction transaction = new Transaction(0, aid, amount, 0, note);
                //insert into db
                boolean isSuccess = transactionSessionBean.AddNewTransaction(transaction);
                if(isSuccess){
                    accountSessionBean.updateTransactionList(account);
                }
                rs += isSuccess == true ?" Success ": " Failed!";
                System.out.println("add transaction result:" + rs);
            }
            request.setAttribute("AddingResult",rs);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addtransaction.jsp");
            dispatcher.forward(request, response);
        }
    }

}
