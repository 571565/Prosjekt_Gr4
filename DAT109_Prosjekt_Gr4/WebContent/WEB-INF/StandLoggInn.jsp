<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Stands</title>
</head>
<body>
	<h3>Stands</h3>

<form method="post">
    <fieldset>
        <p>Stand <select name="standedit" >
        	<c:forEach items="${stands}" var="stand">
        		<option value = "${stand.navn}">${stand.navn}</option>
			</c:forEach>
        </select></p>
    </fieldset>

		<fieldset>
			<label for = "passord">Passord: </label><input type = "password" name ="passord">
			<p><input type="submit" value="Logg Inn"></p>
		</fieldset>
	</form>
</body>
</html>