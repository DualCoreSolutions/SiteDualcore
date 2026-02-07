package br.com.dualcore.controller;

import br.com.dualcore.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.List; // Import necessário para a proteção contra duplicados
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @PersistenceContext(unitName = "SiteDualcorePU")
    private EntityManager em;

    @Transactional
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String loginDigitado = request.getParameter("login");
        String senhaDigitada = request.getParameter("senha");

        System.out.println("Tentativa de login para: " + loginDigitado);

        try {
            // BUSCA BLINDADA: Usamos getResultList para evitar o erro de 'More than one result'
            List<Usuario> resultados = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class)
                                         .setParameter("login", loginDigitado)
                                         .getResultList();

            if (resultados.isEmpty()) {
                System.out.println("Usuário não encontrado: " + loginDigitado);
                // Mude de .html para .jsp
                response.sendRedirect("dashboard.jsp");
                return; // Encerra o método aqui
            }

            // Pega o primeiro usuário da lista (o mais antigo ou único)
            Usuario user = resultados.get(0);

            // VERIFICAÇÃO DE SEGURANÇA (BCrypt + Texto Puro)
            boolean senhaValida = false;
            if (user.getSenha() != null && user.getSenha().startsWith("$2a$")) {
                senhaValida = BCrypt.checkpw(senhaDigitada, user.getSenha());
            } else {
                senhaValida = user.getSenha() != null && user.getSenha().equals(senhaDigitada);
            }

            if (senhaValida) {
                System.out.println("Login com sucesso para: " + loginDigitado);
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogado", user);
                response.sendRedirect("dashboard.jsp"); 
            } else {
                System.out.println("Senha incorreta para o usuário: " + loginDigitado);
                response.sendRedirect("index.html?erro=1");
            }

        } catch (Exception e) {
            System.out.println("Erro crítico na autenticação: " + e.getMessage());
            e.printStackTrace();
            response.sendRedirect("index.html?erro=2");
        }
    }
}