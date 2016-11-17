<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bullhorn Login</title>
</head>
<body>
	<form action="Login" method="get">
	  <p>Email:</p>
	  <input type="text" name="email" id="email" value="">
	  <br>
	  <p>Password:</p>
	  <input type="password" name="password" id="password" value="">
	  <br>
	  <br>
	  <input type="submit" value="Submit">
	</form> 
	
	<p>If you click the "Submit" button, the form-data will be sent to a page called "action_page.php".</p>
</body>
</html>