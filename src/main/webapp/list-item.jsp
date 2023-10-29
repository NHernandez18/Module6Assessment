<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movies and books</title>
</head>
<body>
	
	List of books and movies:
	<table>
		<c:forEach items="${requestScope.allMovies}" var="currentmovie">
			<tr>
			 	<%-- <td><input type="radio" name="id" value="${currentitem.id}"></td>--%>
				 <td>${currentmovie.title}</td>
				 <td>${currentmovie.year}</td>
			 </tr>
		
		<c:forEach items="${requestScope.allBooks}" var="currentbook">
			<tr>
				 <%-- <td><input type="radio" name="id" value="${currentitem.id}"></td>--%>
				 <td>${currentbook.title}</td>
				 <td>${currentbook.author}</td>
				</tr>
		</c:forEach>
		</c:forEach>
	</table>  
	<br />
	<a href="index.html">Home</a>
	
</body>
</html>