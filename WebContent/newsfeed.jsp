<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Newsfeed</title>
	<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<h2>Message successfully posted</h2>

	<% String posttext = (String)request.getAttribute("posttext");%>
	<h2><%=(posttext)%></h2>
	<!--<a href="home.jsp">Back to home</a>-->
	<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>