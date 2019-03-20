<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Hjem</title>
</head>
<body>
	<h3>Tidligere stemmer</h3>
	<c:forEach items="${Stemme}" var="">
		<p><a href = "Stemme">${standid}</a>, ${poeng} poeng</p>
	</c:forEach>
    <p><input type="submit" value="Scan QR"></p>
</body>
</html>