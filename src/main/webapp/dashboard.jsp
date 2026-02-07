<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.dualcore.model.Usuario"%>
<%
    // PROTEÇÃO: Verifica se o usuário passou pelo login
    Usuario user = (Usuario) session.getAttribute("usuarioLogado");
    if (user == null) {
        response.sendRedirect("index.html?erro=acesso_negado");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - DualCore Solutions</title>
    <style>
        body { font-family: Arial; background-color: #f4f4f4; padding: 20px; }
        .card { background: white; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px #ccc; }
        .header { display: flex; justify-content: space-between; align-items: center; }
        .btn-sair { color: red; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>
    <div class="card">
        <div class="header">
            <h1>Painel de Controle</h1>
            <a href="LogoutServlet" class="btn-sair">Sair</a>
        </div>
        <hr>
        <h2>Olá, <%= user.getLogin() %>! 👋</h2>
        <p>Você está acessando a infraestrutura da <strong>DualCore Solutions</strong>.</p>
    </div>
</body>
</html>