package inter.asign;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form_asign
 */
@WebServlet("/Form_asign")
public class Form_asign extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter w=resp.getWriter();
		
		
		w.println("<form action=\"add\">\r\n"
				+ "	<label>First name</label><br/>\r\n"
				+ "	<input type=\"text\" name=\"fname\" ><br/>\r\n"
				+ "	<label>Last name</label><br/>\r\n"
				+ "	<input type=\"text\" name=\"lname\" ><br/>\r\n"
				+ "	<label>Address</label><br/>\r\n"
				+ "	<input type=\"text\" name=\"address\" ><br/>\r\n"
				+ "	<label>city</label><br/>\r\n"
				+ "	<input type=\"text\" name=\"city\" ><br/>\r\n"
				+ "	<label>state</label><br/>\r\n"
				+ "	<input type=\"text\" name=\"state\" ><br/>\r\n"
				+ "	<label>Email</label><br/>\r\n"
				+ "	<input type=\"email\" name=\"email\" ><br/>\r\n"
				+ "	<label>Phone</label><br/>\r\n"
				+ "	<input type=\"number\" name=\"phone\" ><br/>\r\n"
				+ "	<input type=\"submit\" value=\"add\">\r\n"
				+ "</form>");
		
	}
}
