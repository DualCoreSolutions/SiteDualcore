<%-- 
    Document   : login
    Created on : 10 de fev. de 2026, 21:24:18
    Author     : Bruno Borges
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Dashboard - DualCore Solutions</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="estilos.css?v=2">
    </head>
    <body class="login-body"> 
        <div class="login-box">
            <img src="images/login.png" alt="Logo DualCore" class="login-logo">

            <h2 style="color: #2c3e50; margin-bottom: 20px;">Acesso ao Sistema</h2>

            <form action="LoginServlet" method="POST" style="width: 100%;">
                <input type="text" name="login" placeholder="usuário" required>
                <input type="password" name="senha" placeholder="********" required>
                <button type="submit" class="btn-salvar" style="width: 100%; margin-top: 10px;">Entrar</button>
            </form>

            <p style="margin-top: 20px;">
                Novo por aqui? <a href="cadastro.jsp" style="color: #1e3a8a; font-weight: bold;">Cadastre-se</a>
            </p>
        </div>
    </body>
</html>