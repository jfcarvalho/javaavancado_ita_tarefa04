<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de T�picos</title>
</head>
<body>

<h3>Rela��o de T�picos Cadastrados</h3>

<table>
<tr>
<th> T�tulo do t�pico</th>
<th> Usu�rio criador</th>
</tr>

<c:forEach items="${topicos}" var="topico">
<tr>
<td><a href="visualizarTopico?id=${topico.getId_topico()}">${topico.getTitulo()}</a></td>
<td>${topico.getUsuario().getNome()}</td>
</tr>

</c:forEach>
	
</table>

<br>

<span><a href="cadastroTopico.jsp">Incluir novo t�pico</a></span> |
<span><a href="Ranking">Ranking de Usu�rios</a></span>

</body>
</html>