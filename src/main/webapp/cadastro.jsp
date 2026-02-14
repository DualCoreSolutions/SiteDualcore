<%-- 
    Document   : cadastro
    Created on : 13 de fev. de 2026, 20:49:57
    Author     : Bruno Borges
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DualCore Solutions - Login</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="estilos.css?v=2">
    </head>
    <body class="cadastro-body">
        <div class="login-box"> <img src="images/cadastro.png" alt="Logo DualCore" class="login-logo">
            <hr> 
            <form action="CadastroServlet" method="POST">
                <h2>Novo por aqui? Cadastre-se</h2>
                <input type="text" name="novoLogin" placeholder="Escolha um usuário" required>
                <input type="password" name="novaSenha" placeholder="Escolha uma senha" required>
                <button type="submit" class="btn-salvar" style="width: 100%;">Criar Conta</button>
                <p><a href="login.jsp" style="color: #1e3a8a; font-weight: bold;">Voltar para o Login</a></p>
            </form>
        </div>
    </body>
</html>
