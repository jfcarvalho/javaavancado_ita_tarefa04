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

<h2>Exibi��o de T�pico</h2>

<table>
<tr>
<td> T�tulo do t�pico: ${topico.getTitulo()} </td>
</tr>
<tr>
<td> Usu�rio criador: ${topico.getUsuario().getLogin()}</td>
<tr>
<td> Conte�do: ${topico.getConteudo()} </td>
</tr>

</table>

<h4>Exibi��o dos coment�rios</h4>

<table>

<c:forEach items="${comentarios}" var="comentario">

<tr><td>Autor: ${comentario.getUsuario().getNome()}</td> </tr>
<tr><td>Coment�rio: ${comentario.getComentario()}</td></tr>
<tr><td><br></td></tr>


</c:forEach>

</table>

<br>

<span><a href="CadastroComentario?id_topico=${topico.getId_topico()}&login=${usuario.getLogin()}">Incluir novo comentario</a></span>

</body>
</html>

