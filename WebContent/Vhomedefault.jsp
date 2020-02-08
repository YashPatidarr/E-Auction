<%@page import="Vendor.VloginBean"%>
<%@page import="Vendor.VendorLogin"%>
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
		<font size="6" color="Green">Vendor Home</font>
	</h5>
	<hr>


	<%
		//import VendorLogin;
		HttpSession hs = request.getSession();
		//String email = (String)hs.getAttribute("id");
		VloginBean vs = (VloginBean) hs.getAttribute("object");

		//out.println("Admin ID :-  "+ email);
		String email = vs.getemail();
		out.println("Vendor id:- " + email);
		hs.setAttribute("object", vs);
	%>
	<hr>
	<br>
	<div class="container" align="center">
		<nav class="main-header__nav">
			<ul class="main-header__item-list">
				<li class="main-header__item"><a href="AddProduct.jsp">Add Product</a></li>
				<li class="main-header__item"><a href="ProductServletVendor">Show Products</a></li>
				<li class="main-header__item"><a href="AuctProductServletVendor">Auctioned Products</a></li>
				<li class="main-header__item"><a href="ProductServletVendor">Sold Products</a></li>
				<li class="main-header__item"><a href="index.jsp">Logout</a></li>
			</ul>


		</nav>
	</div>
	
</header>
<br>
	<br>
	<br>
</html>