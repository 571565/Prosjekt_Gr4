<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jury Side</title>
</head>
<body>
	<h2>Poengsum for hver stand</h2>
		<fieldset>
		<c:forEach items="${stand}" var="stand">
			<p>${stand.navn}, Totalscore = ${stand.totalscore}</p>	
		</c:forEach>
		</fieldset>
		
</body>
</html>