

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletingUserDetails
 */
@WebServlet("/DeletingUserDetails")
public class DeletingUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletingUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Delete user music here
		PrintWriter pr=response.getWriter();
		if((request.getParameter("musicc"))==null)
		{  
			pr.write("<html><body background='C:\\Users\\SIDDHARTH\\Desktop\\a7.png'>");
			pr.write("No music to delete");
			pr.write("<a href='UserHomePage.jsp'>GoToHomePage</a></body></html>");
			
		}
		else {
		try{
			String songname=request.getParameter("musicc");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstore","root","");
			Statement smt;
			smt=conn.createStatement();
			System.out.println(songname);
			smt.executeUpdate("delete from usermusic where songname='"+songname+"'");

	}catch(Exception e){
		e.printStackTrace();
	}
		pr.write("<html><body background='C:\\Users\\SIDDHARTH\\Desktop\\a7.png'>");
		pr.write("Music Deleted Succesfully");
		pr.write("<a href='UserHomePage.jsp'>GoToHomePage</a></body></html>");

		
	}   }

}
