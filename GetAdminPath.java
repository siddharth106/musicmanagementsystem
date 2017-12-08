

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAdminPath
 */
@WebServlet("/GetAdminPath")
public class GetAdminPath extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAdminPath() {
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
		String s1=request.getParameter("AddMusic");
		String s2=request.getParameter("DeleteMusic");
		String s3=request.getParameter("LogOut");

		if(s1!=null)
			response.sendRedirect("GetAdminMusicDetails.jsp");
		if(s2!=null)
			response.sendRedirect("DelAdminMusicDetails.jsp");
		if(s3!=null){
			request.getSession().setAttribute("myname",null);
			request.getSession().setAttribute("pwd",null);
			response.sendRedirect("login.jsp");   }
	}

}
