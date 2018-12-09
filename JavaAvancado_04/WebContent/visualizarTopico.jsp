<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exibindo topicos</title>
</head>
<body>

<h2>Exibição de Tópico</h2>

<table>
<tr>
<td> Título do tópico: ${topico.getTitulo()} </td>
</tr>
<tr>
<td> Usuário criador: ${topico.getUsuario().getLogin()}</td>
<tr>
<td> Conteúdo: ${topico.getConteudo()} </td>
</tr>

</table>

<h4>Exibição dos comentários</h4>

<table>

<c:forEach items="${comentarios}" var="comentario">

<tr><td>Autor: ${comentario.getUsuario().getNome()}</td> </tr>
<tr><td>Comentário: ${comentario.getComentario()}</td></tr>
<tr><td><br></td></tr>


</c:forEach>

</table>

<br>

<span><a href="CadastroComentario?id_topico=${topico.getId_topico()}&login=${usuario.getLogin()}">Incluir novo comentario</a></span>

</body>
</html>

