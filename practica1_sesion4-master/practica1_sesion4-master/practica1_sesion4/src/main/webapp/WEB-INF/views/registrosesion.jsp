<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro</title>
</head>
<body>
	<h1>Introduzca sus datos:</h1>
	
	<form action="Sesion" method="post">
		Nombre: <br /><input type="text" name="nombre" size="20"><br />
		Apellidos: <br /><input type="text" name="apellidos" size="20"><br />
		Email: <br /><input type="text" name="useremail" size="20"><br />
		Contrase�a: <br /><input type="text" name="pass" size="20"><br />
		Tel�fono: <br /><input type="text" name="telefono" size="20"><br />
		Codigo postal: <br /><input type="text" name="codpost" size="20"><br />
		<br /><input type="submit" value="Registrarse">
	</form>
</body>
</html>