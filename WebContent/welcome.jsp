<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*" %>
    <%
			//String userssession = (String)request.getAttribute("username");
		   // pageContext.setAttribute("username", userssession);
		    HttpSession sessionid = request.getSession(false);
		    //pageContext.setAttribute("session", sessionid);
		    
		    if (session == null){
		    	request.getRequestDispatcher("login.jsp").forward(request, response);
		    }
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<!-- first commit -->
		<link rel="icon" type="image/png" href="images/icon.png">
		<title>AES</title>
		<link href = "css/bootstrap.min.css" rel = "stylesheet">
		<link rel="icon" type="image/png" href="images/encrypt.png">
		<script language="Javascript">
				function doCheck(){
				    var allFilled = true;
		
				    var inputs = document.getElementsByTagName('input');
				    for(var i=0; i<inputs.length; i++){
				        if(inputs[i].type == "text" && inputs[i].value == ''){
				        allFilled = false;
				        break;
				        }
				    }
		
				    document.getElementById("encryptBtn").disabled = !allFilled;
				    document.getElementById("decryptBtn").disabled = !allFilled;
				}
				
		
				window.onload = function(){
				    var inputs = document.getElementsByTagName('input');
				    for(var i=0; i<inputs.length; i++){
				        if(inputs[i].type == "text"){
				        inputs[i].onkeyup = doCheck;
				        inputs[i].onblur = doCheck;
				        }
				    }
				};
		
		
				function encrypt()
				{
				    document.dataForm.action = "Encrypt";  
				    document.getElementById("encryptionType").value = "encrypt";   
				    document.dataForm.submit();             // Submit the page
				    return true;
				}
				
				function decrypt()
				{
				    document.dataForm.action = "Encrypt";
				    document.getElementById("encryptionType").value = "decrypt";
				    document.dataForm.submit();             // Submit the page
				    return true;
				}
				
		</script>
	</head>
	<body>
		<div class="container">
			<div class="page-header">
				<h1><strong>AES </strong><small>Encryption & Decryption</small></h1>
			<div>
				<form name="dataForm" class="navbar-form navbar-left" method="POST">
				<div>
					    <div class="form-group">
					         <input type="text" id=textField class="form-control" name="textProvided" style="width:300px" placeholder="Text goes here !!">
					         <input type="hidden" id="encryptionType" name="encryptionType"/>
					    </div>
					    <div style="height:20px"></div>
					    <div style="clear:both">
						     <button type="button" id=encryptBtn class="btn btn-success" onClick="encrypt();" disabled>Encrypt</button>
						     <button type="button" id=decryptBtn class="btn btn-primary" onClick="decrypt();" disabled>Decrypt</button>	<br><br>
					    </div>
					   </div>
			     </form>
			</div>
									
			<div>
				<div><font face="verdana">${input}</font></div>  
				<div><font face="verdana">${error}</font></div>
				<div><font face="verdana">${output}</font></div>
			</div>
		</div>
	</body>
</html>