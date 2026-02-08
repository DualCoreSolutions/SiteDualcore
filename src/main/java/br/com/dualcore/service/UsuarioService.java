package br.com.dualcore.service;

import br.com.dualcore.model.Produto;
import br.com.dualcore.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless // Isso garante que o Payara SEMPRE abra uma transação
public class UsuarioService {

    @PersistenceContext(unitName = "SiteDualcorePU")
    private EntityManager em;

    public void cadastrar(Usuario usuario) {
        em.persist(usuario);
    }
    
}