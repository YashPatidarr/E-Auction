<%@page import="p1.UloginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="main.css">
</head>
<style>

</style>

<header class ="main-header">

<h1 align="center"><font size="12" color ="red"> E-Auction</font></h1>
<h5 align="center"><font size="6" color ="Green">User Home</font></h5>

<hr>

<%

HttpSession  hs = request.getSession();

UloginBean ul = (UloginBean)hs.getAttribute("object");
String useremail = ul.getemail();
out.println(useremail);
%>

<hr>
<br>
<div class="container" align ="center">
<nav class="main-header__nav">
 <ul class="main-header__item-list">
 <li class="main-header__item"> <a href="UProfile.jsp">My Profile</a></li>  
 <li class="main-header__item"> <a href="ProductServlet1">Show Products </a></li>
 <li class="main-header__item">  <a href="BidingDetails">Bided Items </a></li>
 <li class="main-header__item">  <a href="UserPro">Notifications </a></li>
 <li class="main-header__item"> <a href="index.jsp">Logout </a></li>
   </ul>
  
  
</nav>
</div>
<br><br><br> 
</header>
<body>
<br><br><br></body>
</html>