/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modeljpa.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author PC_LENOVO
 */
@Entity
@Table(name = "tb_venda_itens")
public class VendaItens implements  Serializable{
    
     @Id
    @SequenceGenerator(name = "seq_venda_itens",sequenceName = "seq_venda_itens_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_venda_itens",strategy = GenerationType.SEQUENCE)
    private Integer id;
     
      @NotNull(message = "A quantidade  deve ser informada")
    @Min(value = 0,message = "A quantidade nao pode ser negativa")
    @Column(name = "quantidade",nullable = false,columnDefinition = "decimal(12,2)")
    private Double quantidade;
      
       @NotNull(message = "O valor unitario  deve ser informado")
    @Min(value = 0,message = "O valor unitario  nao pode ser negativo")
    @Column(name = "valor_unitario",nullable = false,columnDefinition = "decimal(12,2)")
    private Double valorUnitario;
    
     @NotNull(message = "O valor total  deve ser informado")
    @Min(value = 0,message = "O valor Total  nao pode ser negativo")
    @Column(name = "valor_total",nullable = false,columnDefinition = "decimal(12,2)")
    private Double ValorTotal;
    
    
    @NotNull(message = "A venda nao pode ser  nula")
    @ManyToOne
    @JoinColumn(name = "venda",referencedColumnName = "id",nullable = false)
    private Venda venda;
    
    @NotNull(message = "O produto nao pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "produto",referencedColumnName = "id",nullable = false)
    private Produto produto;

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
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorUnitario
     */
    public Double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the ValorTotal
     */
    public Double getValorTotal() {
        return ValorTotal;
    }

    /**
     * @param ValorTotal the ValorTotal to set
     */
    public void setValorTotal(Double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    /**
     * @return the venda
     */
    public Venda getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final VendaItens other = (VendaItens) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
            
            
            
    
}
