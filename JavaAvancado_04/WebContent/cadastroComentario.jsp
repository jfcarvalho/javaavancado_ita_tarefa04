<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Coment�rio</title>
</head>
<body>

<h2>Cadastro de Coment�rio</h2>

<form method="POST" action="CadastroComentario">
	
	<label>Conteudo: </label><textarea name="comentario"></textarea>
	<input type="hidden" name="id_topico" value="${topico.getId_topico()}"/>
	<br>
	
	<input type="submit" value="Cadastrar Comentario"/>
	
</form>

</body>
</html>