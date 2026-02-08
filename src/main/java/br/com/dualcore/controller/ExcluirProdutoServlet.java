package br.com.dualcore.controller;

import br.com.dualcore.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ExcluirProdutoServlet")
public class ExcluirProdutoServlet extends HttpServlet {

    @Inject
    private ProdutoService produtoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // Pega o ID enviado pelo link do dashboard
            String idParam = request.getParameter("id");
            if (idParam != null) {
                Long id = Long.parseLong(idParam);
                
                // Chama o serviço transacional para deletar
                produtoService.excluir(id);
                System.out.println("DualCore - Produto ID " + id + " excluído com sucesso.");
            }
            
            // Redireciona de volta para o Dashboard para atualizar a lista
            // Importante: Redirecione para o seu Servlet que carrega a lista, não direto para o .jsp
            response.sendRedirect("DashboardServlet"); 
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("dashboard.jsp?erro=exclusao");
        }
    }
}