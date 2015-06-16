<%-- 
    Document   : calculator
    Created on : 13/06/2015, 7:49:50 PM
    Author     : Eric
--%>

<%@page import = "javax.servlet.RequestDispatcher" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String calculationHtml = "";
    if(request.getAttribute("calculationHtml")!=null){
        calculationHtml = request.getAttribute("calculationHtml").toString();
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
        <h2>Calculator:</h2>
        <div>
            <form method="post" action="CalculatorServlet">
            <p>
                <select name="type">
                    <option value="0">Saving</option>
                    <option value="1">Borrow</option>
                </select>
            </p>
            <p>Month: <br /><input type="text" name="month" /></p>
            <p>Amount: <br /><input type="text" name="amount" /></p>
            <p><input type="submit" name="submit" value="Calculate" class="inputSubmit" /></p>
        </form>
        </div>
        <div><%= calculationHtml %></div>
    </div>
    
    <div class="mainBox">
    	<div class="footer">Money Bucket @ Eric Shang</div>
    </div>
    </body>
</html>