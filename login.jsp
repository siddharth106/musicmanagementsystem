<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
marquee{color:#105B0D; font-size:4em;}
.ab{ background-color:#D7BF18; }
span{ display:inline; width:100; }
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Music Store Management</title>
</head>
<body background="C:\\Users\\SIDDHARTH\\Desktop\\a6.jpg">

        <marquee>Welcome to Online Music Store</marquee><br><br>
<form action="GetLogin" method="post">
<span class=ab>Login Name :</span><br> <br><input type="text" name="name"><br><br>
<span class=ab >Password :</span> <br><br><input type="text"  name="password"><br><br>
<input type="submit"  name="UserLogin" value="UserLogin">
<input type="submit"  name="AdminLogin" value="AdminLogin">
<input type="submit"  name="SignUp" value="SignUp">
</form>
</body>
</html>
