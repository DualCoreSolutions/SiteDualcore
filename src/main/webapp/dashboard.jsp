<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.dualcore.model.Usuario"%>
<%@page import="br.com.dualcore.model.Produto"%>
<%@page import="java.util.List"%>
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
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body class="dash-body">
    <div class="card-card">
        <div class="header">
            <h1>Painel de Controle</h1>
            <a href="LogoutServlet" class="btn-sair">Sair</a>
        </div>
        <hr>
        <h2>Olá, <%= user.getLogin() %>! 👋</h2>
        <p>Você está acessando a infraestrutura da <strong>DualCore Solutions</strong>.</p>
    </div>
        
    <hr>
    
    <div class="card">
        <h3>📦 Cadastrar Novo Ativo no Inventário</h3>
        <form action="ProdutoServlet" method="POST" class="form-cadastro">
            <input type="text" name="nome" placeholder="Nome do Produto" required>
            <input type="number" name="quantidade" placeholder="Qtd" required>
            <input type="number" step="0.01" name="preco" placeholder="Preço" required>
            <input type="text" name="descricao" placeholder="Descrição">
            <button type="submit" class="btn-salvar">Salvar no Banco</button>
        </form>
    </div>
    
    <h3>Inventário de Ativos - DualCore</h3>
    <table border="1" style="width:100%; text-align:left; background-color: white; border-collapse: collapse;">
        <tr style="background-color: #007bff; color: white;">
            <th>ID</th>
            <th>Nome</th>
            <th>Qtd</th>
            <th>Preço</th>
            <th>Descrição</th>
        </tr>
        <%
            List<Produto> lista = (List<Produto>) request.getAttribute("listaProdutos");
            if (lista != null) {
                for (Produto p : lista) { // Início do loop
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNome() %></td>
            <td><%= p.getQuantidade() %></td>
            <td>R$ <%= String.format("%.2f", p.getPreco()) %></td>
            <td><%= p.getDescricao() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">Nenhum produto encontrado. Carregando...</td>
        </tr>
        <% } %>
    </table>
    
</body>
</html>