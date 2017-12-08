<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
marquee{color:#105B0D; font-size:4em;}
span{color:#105B0D;}
</style>
</head>
<body background="C:\\Users\\SIDDHARTH\\Desktop\\a7.jpg">
<%
String n=(String)request.getSession().getAttribute("myname");
%>
<form action="GetAdminPath" method="post">
<%  if(n!=null && n!=""){
	%>
	<p><marquee>Welcome : <%out.print(n); %></marquee></p>
<p><input type="submit" name="AddMusic" value="AddMusic"></p>
<p><input type="submit" name="DeleteMusic" value="DeleteMusic"></p>
<p><input type="submit" name="LogOut" value="LogOut"></p>
</form>
	<%
}
else{
	response.sendRedirect("login.jsp");
	
}
	%>

</body>
</html>