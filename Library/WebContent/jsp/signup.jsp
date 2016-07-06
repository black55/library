<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<script type="text/javascript" src="js/jqueryLib/jquery-3.0.0.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Library</title>
</head>
<body>
	<div style = "width:100%; max-width:275px; margin:0 auto;">
		<div style = "width:100%;">
			<input type = "text" id = "username" placeholder = "Username"  style = "width:100%;" />
			<div id = 'username_error' style = "width:100%;"></div>
		</div>
		<div>
			<input type = "password" id = "password" placeholder = "Passsword" style = "width:100%;" />
			<div id = 'password_error'></div>
		</div>
		<div style = "width:100%;">
			<input type = "text" id = "email" placeholder = "Email" style = "width:100%;" />
			<div id = 'email_error' style = "width:100%;" ></div>
		</div>
		<div style = "width:100%;">
			<input type = "text" id = "roll" placeholder = "Roll Id" style = "width:100%;" />
			<div id = 'roll_error' style = "width:100%;" ></div>
		</div>
		<div style = "width:100%;">
			<div  style = "width:20%;float:left">
				<input type = "text" id = "country" value = "91" style = "width:100%;" />
				<div id = 'country_error' style = "width:100%;" ></div>
			</div>
			<div style = "width:80%;float:left">
				<input type = "text" id = "mobile" placeholder = "Mobile number" style = "width:100%;"/>
				<div id = 'mobile_error'></div>
			</div>
		</div>
		
		<div>
			<input type = "button" id = "signup" value = "Sign Up" />
		</div>
	</div>
	
	
	<script type="text/javascript">
		$("#signup").click(function(){
			$.ajax({
				url: 'signup',
				data:{	username: $('#username').val(), 
						email: $('#email').val(),
						roll: $('#roll').val(),
						country: $('#country').val(),
						mobile: $('#mobile').val(),
						password: $('#password').val(),
					 },
				success: function(data)
						 {
							console.log(data);
						 }
				
			});
		});
	</script>
</body>
</html>