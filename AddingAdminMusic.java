import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddingAdminMusic
 */
@WebServlet("/AddingAdminMusic")
public class AddingAdminMusic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddingAdminMusic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ms=request.getParameter("nam");
		System.out.println(ms);
		File f1=new File(ms);
		System.out.println("abtraa");
		String path="C:\\Users\\SIDDHARTH\\workspace2\\musicmanagementsystem\\WebContent\\";
		Files.copy(f1.toPath(),(new File(path+f1.getName())).toPath(),StandardCopyOption.REPLACE_EXISTING);
		
		
		//Add admin music here
		String songname=f1.getName();
		String albumname=request.getParameter("albumname");
		String songlen="3";
		String singername=request.getParameter("singername");
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstore","root","");
			Statement smt;
			smt=conn.createStatement();
			smt.executeUpdate("insert into adminmusic values ('"+songname+"','"+albumname+"','"+songlen+"','"+singername+"');");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		response.sendRedirect("AdminHomePage.jsp");
	}

}
