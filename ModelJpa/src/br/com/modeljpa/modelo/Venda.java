/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modeljpa.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author PC_LENOVO
 */
@Entity
@Table(name = "tb_venda")
public class Venda implements  Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_venda",sequenceName = "seq_venda_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_venda",strategy = GenerationType.SEQUENCE)
    private Integer Id;
    @Temporal(TemporalType.DATE)
    @Column(name="data", nullable = false)
    @NotNull(message = "A data nao pode ser nula")
    private Calendar data;
    @NotNull(message = "O valor total deve ser informado")
    @Min(value = 0,message = "O valor total nao pode ser negativo")
    @Column(name = "valor_total",nullable = false,columnDefinition = "decimal(12,2)")
    private Double valorTotal;
    
    @NotNull(message = "A quantidade de parcelas deve ser informada")
    @Min(value=0,message = "A quantidade de parcelas nao pode ser negativo")
    @Column(name = "parcelas",nullable = false)
    private Integer Parcelas;
    
    @NotNull(message = "A pessoa fisica nao pode ser nula")
    @ManyToOne
    @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id",nullable = false)
    private PessoaFisica pessoaFisica;

    @OneToMany(mappedBy = "venda",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = false)
    private List<VendaItens> itens = new ArrayList<>();
    
    public Venda() {
        this.valorTotal =0.0;
    }
    
    
    public void adicionarItem(VendaItens obj){
       
        obj.setVenda(this);
        this.valorTotal += obj.getValorTotal();
        this.itens.add(obj);
        
        
    }
    
    public  void removerItem(int index ){
        
        VendaItens obj = this.itens.get(index);
        this.valorTotal -= obj.getValorTotal();
        this.itens.remove(index);
        
        
        
        
    }
    

    /**
     * @return the Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the Parcelas
     */
    public Integer getParcelas() {
        return Parcelas;
    }

    /**
     * @param Parcelas the Parcelas to set
     */
    public void setParcelas(Integer Parcelas) {
        this.Parcelas = Parcelas;
    }

    /**
     * @return the pessoaFisica
     */
    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    /**
     * @param pessoaFisica the pessoaFisica to set
     */
    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.Id);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the itens
     */
    public List<VendaItens> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<VendaItens> itens) {
        this.itens = itens;
    }
    
    
}
