

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletingAdminMusic
 */
@WebServlet("/DeletingAdminMusic")
public class DeletingAdminMusic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletingAdminMusic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Delete admin music here
		PrintWriter pr=response.getWriter();
		
		try{
				String songname=request.getParameter("songname");
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstor","root","");
				Statement smt;
				smt=conn.createStatement();
			
				ResultSet rs=smt.executeQuery("select * from adminmusic where songname='"+songname+"';");
				if(!rs.next()){
					pr.write("The searched music not present :<br><br>");
					pr.println("");
					pr.println("");
					pr.write("<a href='DelAdminMusicDetails.jsp'>Go Back</a>");
				}
				else{
					smt.executeUpdate("delete from adminmusic where songname='"+songname+"';");
					pr.write("Music Deleted succesfully");
					pr.println("<br><br>");
					pr.println("<br><br>");
					pr.write("<a href='AdminHomePage.jsp'>GoToHomePage</a>");
				
				}
		}catch(Exception e){
			System.out.println("Exection is There");
			e.printStackTrace();
		}
		
		
	}

}
