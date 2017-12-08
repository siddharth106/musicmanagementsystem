<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
span{color:blue;}
</style>
</head>
<body background="C:\\Users\\SIDDHARTH\\Desktop\\a6.jpg">

<%
try{
	
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstore","root","");
	Statement smt;
	smt=conn.createStatement();
	ResultSet rs;
	rs=smt.executeQuery("select * from usermusic where uname='"+session.getAttribute("myname")+"'");
	if(!rs.next()){   %>
	<span>No Music Found</span><br><br>
	<a href="UserHomePage.jsp">homePage</a>
		<% 
	}else{
		%> <form action="player.jsp" method="post">
		      <select name=nae>   <%
	do{
		%>  
		<option value= <%=rs.getString(2) %> ><%=rs.getString(2) %> </option>
		  <% 
		out.println("Song name is :<span> "+rs.getString(2)+"</span><br>");
		out.println("Album name is :<span> "+rs.getString(3)+"</span><br>");
		out.println("Song length is :<span> "+rs.getString(4)+"</span><br>");
		out.println("Singer length is :<span> "+rs.getString(5)+"</span><br>");
		out.println("");
		
		
	}  while(rs.next());
		     

%>     </select>
             <br><br> <input type=submit name=nae value="Done">
                 </form>
<br><br><a href="UserHomePage.jsp"><span>HomePage</span></a>
  <% 
	}}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>