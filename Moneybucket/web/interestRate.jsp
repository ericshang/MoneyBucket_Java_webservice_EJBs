<%-- 
    Document   : interestRate
    Created on : 13/06/2015, 7:38:24 PM
    Author     : Eric
--%>

<%@page import = "javax.servlet.RequestDispatcher" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String InterestListHtml = "";
    if(request.getAttribute("InterestListHtml")!=null){
        InterestListHtml = request.getAttribute("InterestListHtml").toString();
    }else{
        RequestDispatcher dispatcher = getServletContext().
              getRequestDispatcher("/InterestRateServlet");
        dispatcher.forward(request, response);
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="images/default.css" type="text/css" />

<title><%= Globals.SiteGlobal.siteName %></title>
</head>

<body>
    <div class="mainBox">
    
        <div class="divLoginBox"><%= Globals.SiteGlobal.getHeaderLoginStr(session) %></div>
    	<div class="header">
            <img src="images/logo.png" height="40" style="position:absolute; top:0; left:0;">
            <h1 style="display:inline-block; margin:0 0 0 50px">Money Bucket!</h1>
        </div>
        <div>
            <%= Globals.SiteGlobal.headNav %>
        </div>
    </div>
    <div class="mainBox">
        <h2>Interest Rate List:</h2>
        <h3><a href="?act=all">All</a> | <a href="?act=showDeposit">Saving</a> | <a href="?act=showBorrow">Borrow</a></h3>
        <div><%= InterestListHtml %></div>
    </div>
    
    <div class="mainBox">
    	<div class="footer">Money Bucket @ Eric Shang</div>
    </div>
    </body>
</html>
<%
    InterestListHtml = null;
%>