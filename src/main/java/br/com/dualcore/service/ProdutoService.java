package br.com.dualcore.service;

import br.com.dualcore.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProdutoService {

    @PersistenceContext(unitName = "SiteDualcorePU")
    private EntityManager em;

    public void salvar(Produto produto) {
        em.persist(produto);
    }

    public List<Produto> listarTodos() {
        return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }
    public void excluir(Long id) {
        Produto p = em.find(Produto.class, id);
        if (p != null) {
            em.remove(p);
        }
    }
    public void atualizar(Produto p) {
        em.merge(p); // O merge atualiza o registro existente no PostgreSQL
    }

    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }
}