/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import EJBs.AccountSessionBeanLocal;
import Entities.Account;
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
public class LoginServlet extends HttpServlet {
    @EJB
    private AccountSessionBeanLocal accountSessionBean;
    HttpSession session;
    
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
        
        session = request.getSession(false);//check if the session has initiated or not
        String act = request.getParameter("act");
        if(act!=null && act.equals("logout")){//do logout
            session.invalidate();
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }else{
            if(session==null || session.getAttribute("UID") ==null){
            //jump to login page
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            }else{
                doPost(request,response);
            }
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
        
        String username = request.getParameter("username");
        String pw = request.getParameter("password");
        if (username ==null || pw==null || session==null){//go to register page
            doGet(request,response);            
        }else{
            processRequest(request, response);
        }
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
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String pw = request.getParameter("password");
        Account account = accountSessionBean.getAccount(username, pw);//calling EJB
        
        if(account !=null && account.getAid()>0){
            int uid = account.getAid();
            session = request.getSession(true);
            session.setAttribute("Account", account);//passing the ResultSet directly to the jsp
            session.setAttribute("UID", uid);
            session.setAttribute("username", username);
            System.out.println("user logged");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }else{
            System.out.println("user not logged in ");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoginServlet");
            dispatcher.forward(request, response);
        }
    }

}
