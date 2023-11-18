package inter.asign;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Customer_screen extends HttpServlet {
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
	System.out.println("hi");
	resp.setContentType("text/html");
	PrintWriter w=resp.getWriter();
	w.println("<h3>customer list</h3>");
	w.println("<table >\r\n"
			+ "	<tr>\r\n"
			+ "		<th>First Name</th>\r\n"
			+ "		<th>Last Name</th>\r\n"
			+ "		<th>Address</th>\r\n"
			+ "		<th>city</th>\r\n"
			+ "		<th>State</th>\r\n"
			+ "		<th>Email</th>\r\n"
			+ "		<th>Phone</th>\r\n"
			+ "		<th>Action</th>\r\n"
			+ "	</tr>");
	String query="Select * from customer_list";
	try {
		Statement stmt=con.createStatement();
		rst=stmt.executeQuery(query);
		
		while(rst.next()) {
			String val=rst.getString(8);
			w.println(
					 "	<tr>\r\n"
					+ "		<td>"+rst.getString(1)+"</td>\r\n"
					+ "		<td>"+rst.getString(2)+" </td>\r\n"
					+ "		<td>"+rst.getString(3)+"</td>\r\n"
					+ "		<td>"+rst.getString(4)+"</td>\r\n"
					+ "		<td>"+rst.getString(5)+"</td>\r\n"
					+ "		<td>"+rst.getString(6)+"</td>\r\n"
					+ "		<td>"+rst.getInt(7)+"</td>\r\n"
					+ "		<td><a href=\"update?name="+val+"\">Edit</a>&nbsp;&nbsp;<a href=\"delete?name="+val+"\">Delete</a></td>\r\n"
					+ "	</tr>");
			
		}
		w.println("</table>");
		w.println("<form action=\"form\">\r\n"
				+ "	<input type=\"submit\"value=\"add customer\">\r\n"
				+ "</form>");
		
		
		
		
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
}
