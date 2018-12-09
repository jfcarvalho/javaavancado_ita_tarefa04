<%-- 
    Document   : index
    Created on : 16/11/2018, 22:21:25
    Author     : nessk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <title>Atividade 04 Java Avançado</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <h1>Autenticação de Usuário</h1>
            <form method="POST" action="LoginController">
                <label>Login:</label><input type="text" name="login"/><br/>
                <label>Senha:</label><input type="password" name="senha"/><br/>
                <input type="submit" value="Fazer Login" />
            </form>
        </div>
        
        <div>Para cadastrar o usuário, clique <a href="/Javaavancado04/cadastroUsuario.jsp">aqui</a> </div>
   	<br>
   	<div>${erro}</div>
    </body>
</html>
