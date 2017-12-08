<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
span{color:#105B0D; font-size:2em;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="C:\\Users\\SIDDHARTH\\Desktop\\a7.jpg">
<form action="AddingUserDetails" method="post">
<span>Name :&nbsp;&nbsp;<input type="text" name="name"></span><br>
<span>Password :<input type="text" name="password"></span><br>
<span>Phone no :<input type="text" name="phone"></span><br>
<span>Email Id :<input type="text" name="email"></span><br>
<span>Gender : <select name="gender">
<option value="Male">Male :</option>
<option value="Female">Female :</option>  
</select>
</span>
<br>
<input type="submit" name="SignIn" value="Submit">
</form>
</body>
</html>