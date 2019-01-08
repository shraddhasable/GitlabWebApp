package abc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  System.out.println("hello java");
         request.setAttribute("result", DBUtil.getDataFromDatabase());
		 response.sendRedirect("login.jsp");
	}


}
