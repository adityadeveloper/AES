<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
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
				    document.getElementById("loginbtn").disabled = !allFilled;		
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

		</script>
	</head>
	<body>
		<div class="container">
			<div class="page-header">
				<h1><strong>AES </strong><small>Encryption & Decryption</small></h1>
			</div>
			<div>
				<form name="dataForm" class="navbar-form navbar-left" action="logincontroller" method="POST">
					    <div class="form-group">
					         <input type="text" id=textField class="form-control" name="username" placeholder="Username" style="width:300px"><br><br>
					         <input type="password" id=textField class="form-control" name="password" placeholder="Password" style="width:300px"><br><br>				    
							 <button type="submit" id=loginbtn class="btn btn-success"  disabled>Login</button>
			     </form>
			</div>
			<div style="height:80px;clear:both">
	
			<div><br /><br /><font face="verdana">${Error}</font></div><br /><br />
		</div>
	</body>
</html>