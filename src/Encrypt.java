import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Encrypt")
public class Encrypt extends HttpServlet {
	 
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.getRequestDispatcher("welcome.jsp").forward(request, response);	
    }
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			String textProvided = request.getParameter("textProvided");
			String encryptType = request.getParameter("encryptionType");
	
			System.out.println("Encryption Type: "+encryptType);
			  System.out.println("Provided Text : "+textProvided);
			  
			try{
				EncDesc a = new EncDesc();
				String key = "fedcba9876543210";
				String passwordEnc = null;
						if (textProvided !=null &&  !textProvided.isEmpty())
						{			
							switch (encryptType)
							{
								case "encrypt": passwordEnc = a.encrypt(textProvided, key);
								break;
								case "decrypt": passwordEnc = a.decrypt(textProvided, key);
								System.out.println("Error occured");
								break;
								default: passwordEnc=null;
							}
						}
								
				  System.out.println("Processed Text : "+ passwordEnc);
				  
				  Object input = "Input text : "+textProvided;
				  
				  if (encryptType.equals("encrypt")){
					  
					  Object output = "Encrypted value : "+passwordEnc;
					  request.setAttribute("output", output);
					  request.setAttribute("input", input);
					  request.getRequestDispatcher("welcome.jsp").forward(request, response);
				  }
				  else{
					  Object output = "Decrypted value : "+passwordEnc;
					  request.setAttribute("output", output);
					  request.setAttribute("input", input);
					  request.getRequestDispatcher("welcome.jsp").forward(request, response);
				  }
				
				    			
				}
				
		catch (Exception e){
			System.out.println("Error Occured "+e.getMessage());
			Object data = "Error Occured!!! Input length must be multiple of 16 when decrypting with padded cipher";
			  request.setAttribute("error", data);
			  request.getRequestDispatcher("welcome.jsp").forward(request, response);	  
			
		}
	}
}
