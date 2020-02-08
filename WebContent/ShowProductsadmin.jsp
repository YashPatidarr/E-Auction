<%@page import="Product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Admin.AdminLoginBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@page import="p1.DBConn"%>
<%@page import="Admin.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Ahomedefault.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Products</title>
</head>
<body>

<h5 align="center"><font size="4" color ="Blue">All Products</font></h5>
<%

ArrayList<ProductBean> st = (ArrayList<ProductBean>)request.getAttribute("ProductListAdmin");

%>
<table class="bottomBorder" align="center"  border="0.5rem" width="70%" height = "50%">
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
Sold By
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
	String soldby = pb.getsoldby();
	
%>

<tr align="center">
<td><img src="Image/<%=pb.getprid() %>.jpg" height="100" width="100">
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
</td>
<td>
<%=soldby %>
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