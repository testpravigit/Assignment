package inter.asign;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Validation extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String s=req.getParameter("login_id");
	String s1=req.getParameter("password");
	System.out.println(s);
    System.out.println(s1);
    if(s.equals("test@sunbasedata.com")&&s1.equals("Test@123")) {
    	  RequestDispatcher rd=req.getRequestDispatcher("/customer");
    	    rd.forward(req, resp);
    }
    else {}
    
  
}
}
