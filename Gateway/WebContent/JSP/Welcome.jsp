<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%try{
	if(session.getAttribute("email")==null){
		response.sendRedirect("../login.html");
	}else{
		System.out.println(session.getAttribute("email"));
	}
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("../login.html");
	}
%>

 <h1>Welcome ${email}</h1>
</body>
</html>