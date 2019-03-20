<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Stemme</title>
</head>
<body>
<h2>Stem på ${standid}</h2>

<form method="post">
    <fieldset>
        <p>Poeng: <select name = "score">
                <option value = "0">0</option>
                <option value = "1">1</option>
                <option value = "2">2</option>
                <option value = "3">3</option>
                <option value = "4">4</option>
                <option value = "5">5</option>
        </select></p>
        <p><input type="submit" value="Stem"></p>
    </fieldset>
</form>



</body>
</html>