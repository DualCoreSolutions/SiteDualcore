<%-- 
    Document   : editar
    Created on : 8 de fev. de 2026, 12:17:13
    Author     : Bruno Borges
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="estilos.css?v=2">
    </head>
    <body class="dash-body">
        <div class="card">
            <h2>Editar Ativo de Infraestrutura</h2>
            <form action="ConfirmarEdicaoServlet" method="POST">
                <input type="hidden" name="id" value="${produto.id}">
                <input type="text" name="nome" value="${produto.nome}" class="input-padrao">
                <input type="number" name="quantidade" value="${produto.quantidade}" class="input-padrao">
                <input type="text" name="preco" value="${produto.preco}" class="input-padrao">
                <input type="text" name="descricao" value="${produto.descricao}" class="input-padrao">
                <button type="submit" class="btn-salvar">Atualizar no Banco</button>
            </form>
        </div>
    </body>
</html>
