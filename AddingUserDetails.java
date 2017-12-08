

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddingUserDetails
 */
@WebServlet("/AddingUserDetails")
public class AddingUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddingUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    String name=request.getParameter("name");
		    String password=request.getParameter("password");
		    String phone=request.getParameter("phone");
		    String email=request.getParameter("email");
		    String gender=request.getParameter("gender");
		    
		    try{  
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstore","root","");
				Statement smt;
				smt=conn.createStatement();
				smt.executeUpdate("insert into userdetails values ('"+name+"','"+password+"','"+phone+"','"+email+"','"+gender+"');");
				request.getSession().setAttribute("myname",name);
				request.getSession().setAttribute("pwd",password);
				
				response.sendRedirect("UserHomePage.jsp");
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}

}
