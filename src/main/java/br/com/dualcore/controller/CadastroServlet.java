package br.com.dualcore.controller;

import br.com.dualcore.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import java.io.IOException;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {

    @jakarta.inject.Inject
    private br.com.dualcore.service.UsuarioService usuarioService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String login = request.getParameter("novoLogin");
        String senhaPura = request.getParameter("novaSenha");

        try {
            String senhaHash = org.mindrot.jbcrypt.BCrypt.hashpw(senhaPura, org.mindrot.jbcrypt.BCrypt.gensalt());

            Usuario novo = new Usuario();
            novo.setLogin(login);
            novo.setSenha(senhaHash);

            // Deixa o EJB cuidar da transação
            usuarioService.cadastrar(novo);
            
            System.out.println("DualCore - Sucesso via EJB: " + login);
            response.sendRedirect("index.html?sucesso=1");
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("cadastro.html?erro=1");
        }
    }
}