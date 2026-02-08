package br.com.dualcore.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private int quantidade;
    private double preco;
    private String descricao;

    // Gere os Getters e Setters (Botão direito -> Insert Code no NetBeans)
    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}