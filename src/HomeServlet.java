

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbBullhorn;
import model.Bhuser;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.util.Date d = new java.util.Date();
		java.sql.Date postdate = new java.sql.Date(d.getTime());//returns current date
		String posttext = request.getParameter("posttext");
		
		String nextURL = "/error.jsp";
		//need a reference to the session
		//get user out of session. If they don't exist then send them back to the login page.
		//kill the session while you're at it.
		HttpSession session = request.getSession();
		if (session.getAttribute("user")==null){
		    nextURL = "/login.jsp";
		    session.invalidate();
		    response.sendRedirect(request.getContextPath() + nextURL);
		    return;//return prevents an error
		}
		 
		//get user information from session so we can connect to the db
		Bhuser user = (Bhuser)session.getAttribute("user");
		int userid = (int)user.getBhuserid();
		 
		int works = DbBullhorn.insert(postdate, posttext, userid);
	 
		//go to the newsfeed or error
		if (works==1){
//			nextURL = "/newsfeed.jsp";
//			nextURL = "/NewsfeedServlet";
			nextURL = "/NewsfeedServlet?userid="+userid;
//			getServletContext().getRequestDispatcher("/NewsfeedServlet").forward(request, response);
			//request.setAttribute("posttext",posttext);	
		}	
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}

}
