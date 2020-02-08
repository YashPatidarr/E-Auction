<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Registration</title>
</head>
<body ">
<form action="Usignup" method="post">

<h1 align=center><font size="12" color ="red">Register Yourself</font></h1>
<table align="center" text-align="center" border="1" width="50%" height = "50%">


<tr>
<td>Enter Your Name</td>
<td><input type="text" name="nm"></td>
</tr>

<tr>
<td>Enter Password</td>
<td><input type="password" name="pwd"></td>
</tr>

<tr>
<td>Enter Your Email </td>
<td><input type="email" name="email"></td>
</tr>


<tr>
<td>City </td>
<td>
<select name="city">
<option>Indore</option>
<option>Bhopal</option>
<option>Gwaliar</option>
<option>Jabalpur</option>
<option>Ratlam</option>
</select>
</td>
</tr>

<tr>
<td>Gender</td>
<td>Male<input type="radio" name="gen" value ="Male">Female<input type="radio"
name="gen" value ="Female">
</td>
</tr>
<tr>
<td>Enter Your Contact no. </td>
<td><input type="number" name="num"></td>
</tr>
</table>



<h1 align = "center" ><input type="submit" value ="Sign Up" ></h1>

</form>
</body>
</html>