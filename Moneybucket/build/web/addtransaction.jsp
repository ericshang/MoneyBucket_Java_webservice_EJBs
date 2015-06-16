<%-- 
    Document   : addtransaction
    Created on : 12/06/2015, 5:57:06 PM
    Author     : Shang
--%>

<%@page import = "javax.servlet.RequestDispatcher" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String addingResultHtml = "";
    if(request.getAttribute("AddingResult")!=null){
        addingResultHtml = request.getAttribute("AddingResult").toString();
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
    	<h2>Add New Transactions</h2>
        <form method="post" action="?act='doAddTransaction'">
            <p>Transaction Type: <br /> <select name="transactiontype"><option value="1">Deposit</option><option value="-1">Withdraw</option></select></p>
            <p>Amount: <br /> <input name="amount" type="text" /></p>
            <p>Note: <br /> <input name="note" type="text" /></p>
            <p><input name="submit" type="submit" value="Sumit" class="inputSubmit" /></p>
        </form>
        <div><%= addingResultHtml %></div>
    </div>
    
    <div class="mainBox">
    	<div class="footer">Money Bucket @ Eric Shang</div>
    </div>
    </body>
</html>