<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
span{color:#105B0D;}
</style>
</head>
<body background="C:\\Users\\SIDDHARTH\\Desktop\\a8.png">
<form action="DeletingUserDetails" method="post">
<select name=musicc >
<% 
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstore","root","");
	Statement smt;
	smt=conn.createStatement();
	
	ResultSet rs=smt.executeQuery("select * from usermusic where uname='"+session.getAttribute("myname")+"'");
	if(!rs.next()){
		%> <span>No Music Found</span>  <% 
	}
	else{
		
	
	do{    %>
	
	   <%=rs.getString(1)%>
	 
	<option value=<%=rs.getString(2)%> > <%=rs.getString(2)%> </option>
	<% 
	}while(rs.next());
}        }catch(Exception e){
	e.printStackTrace();
}

	


%>
</select>
<br><br><input type="submit" name="Delete" value="Delete"> 
</form>
</body>
</html>