<%@page import="java.sql.ResultSet"%>
<%@page import="p1.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="Admin.AdminLoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Ahomedefault.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h5 align="center"><font size="4" color ="Blue">All Vendors</font></h5>
<%

PreparedStatement preparedStatement = null;
try
{
Connection con = DBConn.createConnection();
String query = "select * from vendor";
//preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
preparedStatement = con.prepareStatement(query);

ResultSet rs = preparedStatement.executeQuery();
%>
<table align="center" text-align="center" border="2" width="50%" height = "50%">
<tr>
<th>
Email-ID
</th>
<th>
Name
</th>
<th>
Seller Name
</th>
<th>
City
</th>
<th>
Number
</th>
<th>
Gender
</th>
<th>
Added By
</th>


</tr>
<%
if(rs.next())
{
	do

{
	String name=rs.getString("name");
	String email=rs.getString("email");
	String city=rs.getString("city");
	String Seller_Name=rs.getString("seller_name");
	String number=rs.getString("num");
	String Gender=rs.getString("gen");
	String added_by=rs.getString("added_by");
%>			

<tr>
<td>
<%=email %>
</td>
<td>
<%=name%>
</td>
<td>
<%=Seller_Name%>
</td>
<td>
<%=city %>
</td>
<td>
<%=number %>
</td>
<td>
<%=Gender %>
</td>
</td>
<td>
<%=added_by %>
</td>
</tr>



				 
<%
}while(rs.next());
}
	
else {
	out.println("no records found");
}

con.close();
}
catch(Exception e)
{
	System.out.println(e);
}
%>
</table>
</body>
</html>