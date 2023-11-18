package inter.asign;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Updatee extends HttpServlet {
	Connection con=null;
	ResultSet rst=null;
	
	PreparedStatement pstmt=null;
	String url="jdbc:mysql://localhost:3306/tap";
	String uname="root";
	String pwd="4321";
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,pwd);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

	
	String fname=req.getParameter("fname");
	String lname=req.getParameter("lname");
	String addr=req.getParameter("address");
	String city=req.getParameter("city");
	String state=req.getParameter("state");
	String email=req.getParameter("email");
	int phone=Integer.parseInt(req.getParameter("phone"));
	String id=req.getParameter("id");
	String query="update customer_list set fname=?,lname=?,adress=?,city=?,state=?,email=?,phone=? where id=? ";
	 try {
		pstmt=con.prepareStatement(query);
		pstmt.setString(1, fname);
		pstmt.setString(2, lname);
		pstmt.setString(3, city);
		pstmt.setString(4, state);
		pstmt.setString(5, addr);
		pstmt.setString(6, email);
		pstmt.setInt(7, phone);
		pstmt.setString(8, id);
		int i=pstmt.executeUpdate();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 RequestDispatcher rd=req.getRequestDispatcher("/customer");
	 rd.forward(req, resp);
	
}
}
