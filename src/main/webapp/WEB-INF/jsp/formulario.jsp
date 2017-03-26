<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
 <sf:form action="mandar.html" method="POST">
 	NOMBRE:	
 	<sf:input path="nombre"/>
 	APELLIDO:
 	<sf:input path="apellido"/>
 	
 	<input type="submit" value="REGISTRAR"/>
	 
 </sf:form>

</body>
</html>