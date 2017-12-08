<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<style>
span{color:red; font-size:2em;}
</style>
</head>
<body background="C:\\Users\\SIDDHARTH\\Desktop\\a7.jpg">
<%String m = (String)request.getAttribute("music");
String aname="",slength="",sname="";
String n = (String)request.getAttribute("username");
int c=1;
%>

<%

try{
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstore","root","");
	Statement smt;
	smt=conn.createStatement();
	ResultSet rs;
	
	rs=smt.executeQuery("select * from adminmusic where songname='"+m+".mp3';");
	
	if(!rs.next())
	{   %>
	    <span> There is No Music Found</span><br><br>
	     <a href="UserHomePage.jsp">Go Back</a>
		<% 
	}
	else {
		
	    out.println("<span>Song name is : "+""+rs.getString(1)+"</span><br>");
		String albumname=rs.getString(2);
		aname=albumname;
		String songlength=rs.getString(3);
		slength=songlength;
		String singername=rs.getString(4);
		sname=singername;
		out.println("<span>Album name is : "+albumname+"</span><br>");
		out.println("<span>Song length is : "+songlength+"</span><br>");
		out.println("<span>Singer name is : "+singername+"</span><br>");
	
	
     
%>
<form action="RedirectFromAddMusic" method="post">
<input type="submit" name="AddMyMusic" value="Add to MyMusic">
<input type="submit" name="Done" value="Done">
<input type="hidden" name="songname" value="<%=m%>" />
<input type="hidden" name="albumname" value="<%=aname%>" />
<input type="hidden" name="songlength" value="<%=slength%>" />
<input type="hidden" name="singername" value="<%=sname%>" />
  </form>
  <%  } }
  catch(Exception e){

  }
  %>
</body>
</html>