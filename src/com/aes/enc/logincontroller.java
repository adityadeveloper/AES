package com.aes.enc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String givenUsername = request.getParameter("username");
		String givenPassword = request.getParameter("password");
		
		userdao user = new userdao();
		
		boolean status = user.authenticate(givenUsername, givenPassword);
		
		  if (status == true){			  
			  request.getRequestDispatcher("welcome.jsp").forward(request, response);
		  }
		  
		  else{
			  Object output = "Please provide valid credentials";
			  request.setAttribute("Error", output);
			  request.getRequestDispatcher("login.jsp").forward(request, response);
		  }
		
		
	}

}
