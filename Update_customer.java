package inter.asign;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Update_customer extends HttpServlet {
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
		
		resp.setContentType("text/html");
		PrintWriter w=resp.getWriter();
		
		String id=req.getParameter("name");
		System.out.println(id);
		String query="Select * from customer_list where id=?";
		String fname=null;
		String lname=null;
		String addr=null;
		String city=null;
		String state=null;
		String email=null;
		int phone=0;
		try {
			 pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			rst=pstmt.executeQuery();
			
			

			
			while(rst.next()) {
				fname=rst.getString(1);
				lname=rst.getString(2);
				addr=rst.getString(3);
				city=rst.getString(4);
				state=rst.getString(5);
				email=rst.getString(6);
				phone=rst.getInt(7);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w.println("<form action=\"updated\">\r\n"
				+ "	<label>First name</label><br/>\r\n"
				+ "	<input type=\"text\" name=\"fname\" value="+fname+" required><br/>\r\n"
				+ "	<label>Last name</label><br/>\r\n"
				+ "	<input type=\"text\" name=\"lname\"value="+lname+"  required><br/>\r\n"
				+ "	<label>Address</label><br/>\r\n"
				+ "	<input type=\"text\" name=\"address\"value="+addr+"  ><br/>\r\n"
				+ "	<label>city</label><br/>\r\n"
				+ "	<input type=\"text\" name=\"city\" value="+city+" ><br/>\r\n"
				+ "	<label>state</label><br/>\r\n"
				+ "	<input type=\"text\" name=\"state\" value="+state+"><br/>\r\n"
				+ "	<label>Email</label><br/>\r\n"
				+ "	<input type=\"email\" name=\"email\"value="+email+"  ><br/>\r\n"
				+ "	<label>Phone</label><br/>\r\n"
				+ "	<input type=\"number\" name=\"phone\"value="+phone+"  ><br/>\r\n"
				+ "	<input type=\"hidden\" name=\"id\" value="+id+">\r\n"
				+ "	<input type=\"submit\" value=\"update\">");
	}
	


}
