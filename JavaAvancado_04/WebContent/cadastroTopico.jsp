<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de T�picos</title>
</head>
<body>

<h2>Cadastro de T�picos</h2>

<form method="POST" action="CadastroTopicoController">
	<label>Titulo: </label><input type="text" name="titulo"/>
	<br>
	<label>Conteudo: </label><textarea name="conteudo"></textarea>
	<br>
	
	<input type="submit" value="Cadastrar Topico"/>
	
</form>

</body>
</html>