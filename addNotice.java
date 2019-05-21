package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addNotice
 */
@WebServlet("/addNotice")
public class addNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNotice() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		String title= request.getParameter("noticetitle");
		String date = request.getParameter("date");
		String message = request.getParameter("message");
		
		System.out.println(title+date);
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
		
		 
		PreparedStatement stmt =  con.prepareStatement("insert into notice(title,date,message)  values(?,?,?)");
		stmt.setString(1,title);
		stmt.setString(2,date);
		stmt.setString(3,message);

		
		int i = stmt.executeUpdate();
		
		response.sendRedirect("/LearningManagementSys/page/coursedetails.jsp");

		System.out.println();
		}catch(Exception e){
			
		}
	}

}
