<%-- 
    Document   : index
    Created on : 11/06/2015, 8:06:20 PM
    Author     : Shang
--%>
<%@page import = "javax.servlet.RequestDispatcher" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String AccountOverviewHtml = "";
    if(request.getAttribute("AccountOverviewHtml")!=null){
        AccountOverviewHtml = request.getAttribute("AccountOverviewHtml").toString();
    }else{
        RequestDispatcher dispatcher = getServletContext().
              getRequestDispatcher("/IndexServlet");
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
    	<h2>Account Overview</h2>
        <ul class="mainUl">
            <%= AccountOverviewHtml %>
        </ul>
    </div>
    
    <div class="mainBox">
    	<div class="footer">Money Bucket @ Eric Shang</div>
    </div>
    </body>
</html>
