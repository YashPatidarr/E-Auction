<%@include file="Vhomedefault.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Add</title>
</head>
<body >
<form action="AddProduct" method="post">

<h1 align=center><font size="12" color ="red">Add Product</font></h1>
<table align="center" text-align="center" border="1" width="50%" height = "50%">


<tr>
<td>Enter Product  Name</td>
<td><input type="text" name="nm"></td>
</tr>





<tr>
<td>Artifacts </td>
<td>
<select name="cat">
<option>Painting</option>
<option>pots</option>
<option>Carpets</option>
<option>Jabalpur</option>
<option>Ratlam</option>
</select>
</td>
</tr>


<tr>
<td>Base Price</td>
<td><input type="number" name="price"></td>
</tr>

<tr>
<td>Start Date of Auction</td>
<td><input type="datetime-local" name="sdate"></td>
</tr>

<tr>
<td>End Date of Auction</td>
<td><input type="datetime-local" name="ldate"></td>
</tr>
<tr>
<td>Description</td>
<td><input type="text" name="desc"></td>
</tr>
<tr>
<td>Local Shiping cost</td>
<td><input type="number" name="lcost"></td>
</tr>
<tr>
<td>Other Shiping cost</td>
<td><input type="number" name="ocost"></td>
</tr>
</table>



<h1 align = "center" ><input type="submit" value ="Add Product" ></h1>
<input type="datetime-local" name="ldate">
</form>
</body>
</html>