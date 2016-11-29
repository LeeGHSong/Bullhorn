

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String message = "You entered " + email + " " + "and " + password;
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		String sql = "select * from bhuser";
//		try{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql); 
////			response.getWriter().append("Company ID\t");
//			boolean ufound = false;
//			while(rs.next()){
//				String targetemail = rs.getString(5);
//				String targetpassword = rs.getString(3);
//				System.out.print(rs.getString(5) + "\t"); //field 5 is user email
//				System.out.println(rs.getString(3));		//field 3 is password				
//				response.getWriter().append(rs.getString(5) + "\t\t");
//				response.getWriter().append(rs.getString(3));				
//				response.getWriter().append("\r\n");
//				if (email == targetemail && password == targetpassword){
//					ufound = true;
//					System.out.println("found");
//					break;
//				}
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//				stmt.close();
//				con.close();
//			}catch(SQLException e){
//				e.printStackTrace();
//			}
//		}		
		//redirect message to another page
		request.setAttribute("message", message);
		String nextURL = "/output.jsp";
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
//		response.sendRedirect(request.getContextPath()+nextURL);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
