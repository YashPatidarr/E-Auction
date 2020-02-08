<%@page import="Product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="p1.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Userhomedefault.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<h5 align="center"><font size="4" color ="Blue">All Products</font></h5>
<%

ArrayList<ProductBean> st = (ArrayList<ProductBean>)hs.getAttribute("Products");

%>
<table align="center" text-align="center" border="2" width="50%" height = "50%">
<tr>
<th>
Product Id
</th>
<th>
Name
</th>
<th>
Category
</th>
<th>
Price
</th>
<th>
Sold By
</th>

</tr>
<%
for(ProductBean pb : st)
{
	String name= pb.getname();
	String prid = pb.getprid();
	String price = pb.getprice();
	String cat = pb.getcat();
	String soldby = pb.getsoldby();
%>
<!-- 
<tr>
<td>
<%=prid %>
</td>
<td>
<%=name%>
</td>
<td>
<%=cat %>
</td>
<td>
<%=price %>
</td>
</td>
<td>
<%=soldby %>
</td>
</tr>

 -->
				 
<%
}
%>

</table>
  
</body>
</html>