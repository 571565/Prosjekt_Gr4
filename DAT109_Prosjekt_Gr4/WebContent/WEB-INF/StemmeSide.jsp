<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Hjem</title>
</head>
<body>
<form method="post">
	<h3>Tidligere stemmer</h3>
	<c:forEach items="${stemme}" var="stemme">
		<p><a href = "Stemme?standid=${stemme.stand}">${stemme.stand}</a>, ${stemme.score} poeng</p>
	</c:forEach>
    <p><input type="submit" value="Logg Ut"></p>
  </form>
</body>
</html>