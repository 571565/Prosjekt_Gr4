<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Standside for ${navn}</title>
</head>
<body>
<h3>Totalscoren til ${navn} er ${totalscore}</h3>

<form method = "post">
		<fieldset>
			<label for = "standnavn">Nytt Standnavn </label><input type = "text" name ="standnavn">
			<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/QR_code_for_mobile_English_Wikipedia.svg/1920px-QR_code_for_mobile_English_Wikipedia.svg.png" alt="QR" height="100" width="100">
			
			<p><input type="submit" value="Submit"></p>
		</fieldset>
	</form>

</body>
</html>