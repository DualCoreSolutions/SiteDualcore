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

@WebServlet("/ConfirmarEdicaoServlet")
public class ConfirmarEdicaoServlet extends HttpServlet {

    @Inject
    private ProdutoService produtoService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1. Recebe os parâmetros do editar.jsp
            String idStr = request.getParameter("id");
            String nome = request.getParameter("nome");
            String qtdStr = request.getParameter("quantidade");
            String precoStr = request.getParameter("preco");
            String desc = request.getParameter("descricao");

            if (idStr != null && !idStr.isEmpty()) {
                Long id = Long.parseLong(idStr);
                int qtd = Integer.parseInt(qtdStr);
                double preco = Double.parseDouble(precoStr);

                // 2. Busca o produto existente (Melhor prática JPA)
                Produto p = produtoService.buscarPorId(id);

                if (p != null) {
                    p.setNome(nome);
                    p.setQuantidade(qtd);
                    p.setPreco(preco);
                    p.setDescricao(desc);

                    // 3. Atualiza no PostgreSQL
                    produtoService.atualizar(p);
                }
            }

            // 4. Volta para o Dashboard para ver a lista atualizada
            response.sendRedirect("DashboardServlet");

        } catch (NumberFormatException e) {
            System.err.println("Erro de conversão de números: " + e.getMessage());
            response.sendRedirect("dashboard.jsp?erro=formato");
        } catch (Exception e) {
            e.printStackTrace(); // Isso mostra o erro detalhado no log do Payara
            response.sendRedirect("dashboard.jsp?erro=geral");
        }
    }
}