<%@page import="Product.BidBean"%>
<%@page import="java.util.ArrayList"%>
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
<h5 align="center"><font size="4" color ="Blue">All Products those are Bided</font></h5>
<%

ArrayList<BidBean> st = (ArrayList<BidBean>)request.getAttribute("ProductList");

%>
<table class="bottomBorder" align="center" text-align="center"  width="70%" >
<tr>

<th>
Product Id
</th>
<th>
Price
</th>
<th>
Bid Date
</th>

<th>
Details
</th>

</tr>
<%
try{
for(int i=0;i<st.size();i++)

{	BidBean pb= st.get(i);
	
	String prid = pb.getprid();
	String price = pb.getprice();
	String date = pb.getdate();
	
	
%>

<tr align="center">

<td>
<%=prid %>
</td>

<td>
<%=price %>
</td>
</td>
<td>
<%=date %>
</td>
<td>
<a href="ViewServlet?prid=<%=prid %>">View</a>
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