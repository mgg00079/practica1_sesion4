<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>Pagina principal</title>

</head>
<body>
<%--Esto es index.html--%>
	
	<h2>Login de usuario</h2>
	<form action="Login" method="post">
		Nombre de usuario: <br /><input type="text" name="name" size="20" required><br />
		Contrase�a: <br /><input type="password" name="pass" size="10" required><br />
		<input type="submit" value="Enviar">
	</form>

</body>
</html>