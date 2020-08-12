<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/ClassServlet?action=updateClass">
		<input type="hidden" name="id" value="<c:out value='${classDetail.id }' />" />
		<input type="text" name="name" placeholder="Enter Name" 
		value="<c:out value='${classDetail.classname }' />" />
		<input type="submit" value="Update Class" />
	
	</form>


</body>
</html>