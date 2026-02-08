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

@WebServlet("/PrepararEdicaoServlet")
public class PrepararEdicaoServlet extends HttpServlet {

    @Inject
    private ProdutoService produtoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { // As exceções precisam estar aqui
        
        try {
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                Long id = Long.parseLong(idParam);
                
                // Busca o produto no banco via EJB
                Produto p = produtoService.buscarPorId(id);
                
                // Passa o objeto para o JSP de edição
                request.setAttribute("produto", p);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            } else {
                response.sendRedirect("DashboardServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("DashboardServlet?erro=edicao");
        }
    }
}