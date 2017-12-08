<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
span{color:#105B0D;}
marquee{font-size:4em; color:orange;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="C:\\Users\\SIDDHARTH\\Desktop\\a8.png">
<%
String n=(String)request.getSession().getAttribute("myname");
   if(n!=null && n!=""){
	   %>
	   <marquee>Welcome : <%out.print(n); %></marquee>
	   <form action="GetUserPath" method="post">

<input type="submit" name="MyMusic" value="MyMusic">
<p><span>Enter music name to search :</span> <input type="text" name="mname"> &nbsp;  <input type="submit" name="Search" value="Search"></p>
<p><input type="submit" name="DeleteMusic" value="DeleteMusic"></p>
<p><input type="submit" name="LogOut" value="LogOut"></p>
<input type="hidden" name="username" value="<%=n%>" />
</form>
	   <% 
   } 
   else{
	   response.sendRedirect("login.jsp");
   }
   %>

</body>
</html>