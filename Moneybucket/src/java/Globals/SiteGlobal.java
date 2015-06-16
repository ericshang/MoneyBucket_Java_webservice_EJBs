/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globals;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Shang
 */
public class SiteGlobal {
    public static final String siteName = "MoneyBucket";
    public static final String headNav ="<ul class='headerNavUl'>"+
                    "<li><a href='./'>home</a></li>"+
                    "<li><a href='AddTransaction'>Add transaction</a></li>"+
                    "<li><a href='ShowAllTransaction'>All Transactions</a></li>"+
                    "<li><a href='CalculatorServlet'>Money Calculator</a></li>"+
                    "<li><a href='InterestRateServlet?act=showAll'>All Interest Rates</a></li>"+
                "</ul>";
    
    public static String getHeaderLoginStr(HttpSession session){
        String headerLoginStr;
        if(session.getAttribute("UID")!=null && session.getAttribute("username")!=null){
            headerLoginStr = "Welcome, <a href='index.jsp'>"+session.getAttribute("username")+"</a>! | "
                + " <a href='LoginServlet?act=logout'>Logout</a> |";
        }else{
            headerLoginStr = "Welcome! | <a href='LoginServlet'>Login</a> | "
            + "<a href='RegisterServlet?act=register'>Register</a>";
        }
        return headerLoginStr;
    }
}
