<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exibindo Ranking</title>

</head>
<body>
<h3>Ranking de Usuários por pontuaçãos</h3>


<ol>
<c:forEach items="${usuarios}" var="usuario">

<li>Nome: ${usuario.getNome()} - Login: ${usuario.getLogin()} - Pontos: ${usuario.getPontos()}
</li>

</c:forEach>
</ol>

</body>