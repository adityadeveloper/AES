package com.aes.enc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        	request.getRequestDispatcher("welcome.jsp").forward(request, response);
         
        }  
        else{  
            request.getRequestDispatcher("login.jsp").forward(request, response);  
        }  
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String givenUsername = request.getParameter("username");
		String givenPassword = request.getParameter("password");
		
		userdao user = new userdao();
		
		boolean status = user.authenticate(givenUsername, givenPassword);
		
		  if (status == true){			  
			  HttpSession session = request.getSession(false);
			  if (session == null){
				  request.getRequestDispatcher("login.jsp").forward(request, response);
			  }
			  else{
		//	  System.out.println(session.toString());
		//	  System.out.println(session.getAttribute("username"));
		//	  request.setAttribute("username", givenUsername);
			  request.getRequestDispatcher("welcome.jsp").forward(request, response);
			  }
		  }
		  
		  else{
			  Object output = "Please provide valid credentials";
			  request.setAttribute("Error", output);
			  request.getRequestDispatcher("login.jsp").forward(request, response);
		  }
	}
}