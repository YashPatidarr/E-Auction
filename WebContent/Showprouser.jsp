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
<h5 align="center"><font size="4" color ="Blue">All-Products</font></h5>
<%

ArrayList<ProductBean> st = (ArrayList<ProductBean>)request.getAttribute("ProductList");

%>
<table class="bottomBorder" align="center"  border="0.5rem" width="70%" height = "50%">

<tr text-align="center" >
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
<th>
Details
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
<td style="width:130px"><img src="Image/<%=prid %>.jpg" height="100" width="100">
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
<td>
<a href="ViewServlet?prid=<%=prid %>" class="button button3">View</a>
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