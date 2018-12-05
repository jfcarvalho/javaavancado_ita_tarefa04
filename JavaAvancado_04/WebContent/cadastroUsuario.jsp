<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>

<h2>Cadastro de Usuário</h2>

<form method="POST" action="CadastroUsuarioController">
	<label>Nome: </label><input type="text" name="nome"/>
	<br>
	<label>Login: </label><input type="text" name="login"/>
	<br>
	<label>Email: </label><input type="text" name="email"/>
	<br>
	<label>Senha: </label><input type="password" name="senha"/>
	<br>
	<input type="submit" value="Cadastrar Usuario"/>
	
</form>


</body>
</html>