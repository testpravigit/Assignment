package inter.asign;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Add_customer extends HttpServlet {
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

		
		String query="insert into customer_list values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, query);
			resp.setContentType("text/html");
			PrintWriter w=resp.getWriter();
			
			String fname=req.getParameter("fname");
			String lname=req.getParameter("lname");
			String addr=req.getParameter("address");
			String city=req.getParameter("city");
			String state=req.getParameter("state");
			String email=req.getParameter("email");
			int phone=Integer.parseInt(req.getParameter("phone"));
			UUID uuid=UUID.randomUUID();
			String uu=uuid.toString();
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, addr);
			pstmt.setString(4, city);
			pstmt.setString(5, state);
			pstmt.setString(6, email);
			pstmt.setInt(7, phone);
			pstmt.setString(8,uu);
			int i=pstmt.executeUpdate();
			System.out.println(i);
			
			
			//code
		

			
			if(i>0&&(fname!=""&&lname!="")) {
			
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
				String query1="Select * from customer_list";
				
					Statement stmt=con.createStatement();
					rst=stmt.executeQuery(query1);
					
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
					w.println("<h3>201,Successfully added</h3>");
				
				
			}
			if(fname==""||lname=="") {
				w.println("<h3>Failure: 400, First Name or Last Name is missing</h3>");
				w.println("<form action=\"form\">\r\n"
						+ "	<input type=\"submit\"value=\"add customer\">\r\n"
						+ "</form>");
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		 RequestDispatcher rd=req.getRequestDispatcher("/customer");
//			w.println("<h3>201,Successfull added</h3>");
//		    rd.include(req, resp);
		
		
		
	}

}
