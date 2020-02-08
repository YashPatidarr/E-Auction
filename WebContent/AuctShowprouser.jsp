<%@page import="Product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@page import="p1.DBConn"%>
<%@include file="Vhomedefault.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Products</title>
</head>
<body>

<h5 align="center"><font size="4" color ="Blue">Added Products</font></h5>
<%

ArrayList<ProductBean> st = (ArrayList<ProductBean>)request.getAttribute("ProductList");

%>
<table class="bottomBorder" align="center" text-align="center" width="70%" >

  
<tr>
<th>
Image
</th>
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
</th>

</tr>
<%
try{
for(int i=0;i<st.size();i++)

{	ProductBean pb= st.get(i);
	String name= pb.getname();
	String prid = pb.getprid();
	String price = pb.getprice();
	String cat = pb.getcat();
	
	
%>

<tr align="center">
<td><img src="Image/sample.jpg" height="100" width="100">
</td>
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
<td>
<a href="ViewServletVendor?prid=<%=prid %>">View</a>
</td>

</tr>


				 
<%
}
}
catch(Exception e)
{
	out.println(e);
}
%>

</table>
  
</body>
</html>