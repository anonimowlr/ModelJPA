/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modeljpa.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author PC_LENOVO
 */

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable{
    @Id
     @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1)
    @GeneratedValue(generator = "seq_produto",strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    private Double preco;
    private Double quantidadeEstoque;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "idendifica_categoria",referencedColumnName = "id")
    private Categoria categoria;
    @ManyToOne
      @JoinColumn(name = "idendifica_marca",referencedColumnName = "id")
    private Marca marca;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_desejos",joinColumns = @JoinColumn(name = "produto",referencedColumnName = "id",nullable = false),
         inverseJoinColumns = @JoinColumn(name = "pessoa_fisica",referencedColumnName = "id",nullable = false),uniqueConstraints = {@UniqueConstraint(columnNames = {"pessoa_fisica","produto"})})

    List<PessoaFisica> desejos = new ArrayList<>();

    public List<PessoaFisica> getDesejos() {
        return desejos;
    }

    public void setDesejos(List<PessoaFisica> desejos) {
        this.desejos = desejos;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the quantidadeEstoque
     */
    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque the quantidadeEstoque to set
     */
    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
            
}
