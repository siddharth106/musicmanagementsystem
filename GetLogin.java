

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetLogin
 */
@WebServlet("/GetLogin")
public class GetLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement smt;
		String name=request.getParameter("name");
		String pwd=request.getParameter("password");
		HttpSession ad=request.getSession();
		String login1=request.getParameter("UserLogin");
		String login2=request.getParameter("AdminLogin");
		String login3=request.getParameter("SignUp");
		
		try{
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstore","root","");
				
				smt=conn.createStatement();
			

		
	
		
		
		if(login1!=null){
			
			ResultSet rs=	smt.executeQuery("select * from userdetails where name='"+request.getParameter("name")+"'"+"and password='"+pwd+"'");
	        if(rs.next()){
	        	
	        	ad.setAttribute("myname", name);
				ad.setAttribute("pwd",pwd );
				response.sendRedirect("UserHomePage.jsp");
	        	 }
	        else{  
	        	response.sendRedirect("login.jsp");
	        }
			
			
		}
			
		if(login2!=null){
			ResultSet rs=	smt.executeQuery("select * from admindetails where name='"+request.getParameter("name")+"'"+"and password='"+pwd+"'");
	        if(rs.next()){
	        	ad.setAttribute("myname", name);
				ad.setAttribute("pwd",pwd );
				response.sendRedirect("AdminHomePage.jsp");
	        	 }
	        else{  
	        	response.sendRedirect("login.jsp");
	        }
			
		}
			
		if(login3!=null){
			
			response.sendRedirect("SignupHomePage.jsp");
		}
		 }catch(Exception e){
				e.printStackTrace();
			} 

		
	}

}
