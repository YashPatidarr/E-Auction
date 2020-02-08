<%@page import="Admin.AdminloginClass"%>
<%@page import="Admin.AdminLoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="main.css">
</head>
<header class="main-header">

	<h1 align="center">
		<font size="12" color="red"> E-Auction</font>
	</h1>
	<h5 align="center">
		<font size="6" color="Green">Admin Home</font>
	</h5>
	<hr>


	<%
		HttpSession hs = request.getSession();
		AdminLoginBean al = (AdminLoginBean) hs.getAttribute("object");
		String adminemail = al.getemail();
		out.println("Admin ID :-  " + adminemail);
	%>
	<hr>
	<br>
	<div class="container" align="center">
		<nav class="main-header__nav">
			<ul class="main-header__item-list">
				<li class="main-header__item"><a href="Addvendor.jsp">Add
						Vendor</a></li>
				<li class="main-header__item"><a href="ProductServletAdmin">Show
						Vendors</a></li>
				<li class="main-header__item"><a href="ProductServletAdmin">Show
						Products </a></li>
				<li class="main-header__item"><a href="index.jsp">Logout </a></li>
			</ul>
		</nav>
	</div>

</header>
<br>
<br>
<br>
</html>