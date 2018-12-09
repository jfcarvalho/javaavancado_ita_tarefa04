<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Comentário</title>
</head>
<body>

<h2>Cadastro de Comentário</h2>

<form method="POST" action="CadastroComentario">
	
	<label>Conteudo: </label><input type="text" name="comentario"/>
	<input type="hidden" name="id_topico" value="${topico.getId_topico()}"/>
	<br>
	
	<input type="submit" value="Cadastrar Topico"/>
	
</form>

</body>
</html>