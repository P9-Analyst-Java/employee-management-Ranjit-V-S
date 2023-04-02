<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Image</title>
</head>
<body>
	<form:form action="/saveImg" method="post" enctype="multipart/form-data" modelAttribute="empImg">
		<table>
			<tr>
				<td>Emp ID:</td>
				<td><form:input type="number" value="${id}" disabled="true" path="emp_id"></form:input></td>
			</tr>
			<tr>
				<td>Profile Picture</td>
				<td><form:input type="file" name="img" path="img"></form:input></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>