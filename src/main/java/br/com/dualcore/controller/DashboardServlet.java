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

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    @Inject
    private ProdutoService produtoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Busca a lista atualizada no banco via Service
        List<Produto> lista = produtoService.listarTodos();
        
        // 2. Calcula o patrimônio total aqui no Java (Lógica de Negócio)
        double total = 0;
        if (lista != null) {
            for (Produto p : lista) {
                total += (p.getPreco() * p.getQuantidade());
            }
        }
        
        // 3. Pendura os dados na "sacola" (request)
        request.setAttribute("listaProdutos", lista);
        request.setAttribute("valorTotalPatrimonio", total);
        
        // 4. Encaminha para o JSP (o usuário nem vê a troca)
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}