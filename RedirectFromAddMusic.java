

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
 * Servlet implementation class RedirectFromAddMusic
 */
@WebServlet("/RedirectFromAddMusic")
public class RedirectFromAddMusic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectFromAddMusic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("AddMyMusic")!=null)
		{
			String username=(String)request.getSession().getAttribute("myname");
			String songname=request.getParameter("songname");
			String albumname=request.getParameter("albumname");
			String songlen=request.getParameter("songlength");
			String singername=request.getParameter("singername");
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstore","root","");
				Statement smt;
				smt=conn.createStatement();
				
				
				smt.executeUpdate("insert into usermusic values ('"+username+"','"+songname+"','"+albumname+"','"+songlen+"','"+singername+"');");
				
			}catch(Exception e){
				e.printStackTrace();
			}
			response.sendRedirect("UserHomePage.jsp");

		}
		
		if(request.getParameter("Done")!=null){
			response.sendRedirect("UserHomePage.jsp");
		}
	}

}
