<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	List of shoes and vehicles:
	<table>
		<c:forEach items="${requestScope.allShoes}" var="currentshoe">
			<tr>
			 	<%-- <td><input type="radio" name="id" value="${currentitem.id}"></td>--%>
				 <td>${currentshoe.brand}</td>
				 <td>${currentshoe.shoe}</td>
			 </tr>
		
		<c:forEach items="${requestScope.allVehicles}" var="currentvehicle">
			<tr>
				 <%-- <td><input type="radio" name="id" value="${currentitem.id}"></td>--%>
				 <td>${currentvehicle.make}</td>
				 <td>${currentvehicle.model}</td>
				</tr>
		</c:forEach>
		</c:forEach>
	</table>  
	<br />
	<a href="index.html">Home</a>
	
</body>
</html>