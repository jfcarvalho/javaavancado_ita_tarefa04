<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de Tópicos</title>
</head>
<body>

<h3>Relação de Tópicos Cadastrados</h3>

<table>
<tr>
<th> Título do tópico</th>
<th> Usuário criador</th>
</tr>

<c:forEach items="${topicos}" var="topico">
<tr>
<td><a href="visualizarTopico?id=${topico.getId_topico()}">${topico.getTitulo()}</a></td>
<td>${topico.getUsuario().getNome()}</td>
</tr>

</c:forEach>
	
</table>

<br>

<span><a href="cadastroTopico.jsp">Incluir novo tópico</a></span> |
<span><a href="Ranking">Ranking de Usuários</a></span>

</body>
</html>