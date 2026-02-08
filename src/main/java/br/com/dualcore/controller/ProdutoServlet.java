package br.com.dualcore.controller;

import br.com.dualcore.model.Produto;
import br.com.dualcore.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {

    @Inject
    private ProdutoService produtoService;

    // O GET serve para listar os produtos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Produto> lista = produtoService.listarTodos();
        request.setAttribute("listaProdutos", lista);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    // O POST serve para salvar um novo produto
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        int qtd = Integer.parseInt(request.getParameter("quantidade"));
        double preco = Double.parseDouble(request.getParameter("preco"));
        String desc = request.getParameter("descricao");

        Produto p = new Produto();
        p.setNome(nome);
        p.setQuantidade(qtd);
        p.setPreco(preco);
        p.setDescricao(desc);

        produtoService.salvar(p);
        
        // Após salvar, redireciona para o GET para atualizar a lista
        response.sendRedirect("ProdutoServlet");
    }
}