

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetUserPath
 */
@WebServlet("/GetUserPath")
public class GetUserPath extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserPath() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=request.getParameter("MyMusic");
		String s2=request.getParameter("DeleteMusic");
		String s3=request.getParameter("LogOut");
		String s4=request.getParameter("Search");
		String s5=request.getParameter("mname");
		String s6=request.getParameter("username");
		

		if(s1!=null)
			response.sendRedirect("GetUserMusicDetails.jsp");
		if(s2!=null)
			response.sendRedirect("DelUserMusicDetails.jsp");
		if(s3!=null)
			response.sendRedirect("login.jsp");
		if(s4!=null){
			request.setAttribute("music",s5);
			//request.getRequestDispatcher("DisplaySearch.jsp").forward(request, response); 
			request.setAttribute("username",s6);
			request.getRequestDispatcher("DisplaySearch.jsp").forward(request, response); 
			
		}
		
	}
	

}
