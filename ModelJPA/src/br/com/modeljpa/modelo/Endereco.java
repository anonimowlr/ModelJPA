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
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author PC_LENOVO
 */
@Entity
@Table(name="endereco")
public class Endereco  implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco",allocationSize = 1)
    @GeneratedValue(generator = "seq_endereco",strategy = GenerationType.SEQUENCE)
   private Integer id;
    
    
     @Column(name = "nickname", length = 50, nullable = false)
    @NotNull(message = "O nickname nao pode ser nulo")
    @NotBlank(message = "O nickname nao pode ser  em branco")
    @Length(max = 50,message = "O nickname nao pode ter mais de {max} caracteres")
   private String nickname;
     @Column(name = "rua", length = 50, nullable = false)
    @NotNull(message = "a rua nao pode ser nulo")
    @NotBlank(message = "O rua nao pode ser  em branco")
    @Length(max = 50,message = "O rua nao pode ter mais de {max} caracteres")
   private String rua;
     @Column(name = "numero")
     @NotNull(message = "O numero nao pode ser nulo")
     
   private Integer numero;
     @Column(name = "complento", length = 50)
    @NotBlank(message = "O complento nao pode ser  em branco")
    @Length(max = 50,message = "O complento nao pode ter mais de {max} caracteres")
   private String complemento;
    
      @Column(name = "cep", length = 9, nullable = false)
    @NotNull(message = "O cep nao pode ser nulo")
    @NotBlank(message = "O cep nao pode ser  em branco")
    @Length(max = 8,message = "O cep nao pode ter mais de {max} caracteres")
    
   private String cep;
      
      @Column(name = "bairro", length = 50, nullable = false)
    @NotNull(message = "O bairro nao pode ser nulo")
    @NotBlank(message = "O bairro nao pode ser  em branco")
    @Length(max = 50,message = "O bairro nao pode ter mais de {max} caracteres")
   private String bairro;
      @Column(name = "referencia", length = 30, nullable = false)
    @NotNull(message = "O referencia nao pode ser nulo")
    @NotBlank(message = "O referencia nao pode ser  em branco")
    @Length(max = 30,message = "O referencia nao pode ter mais de {max} caracteres")
   private String referencia;
      @NotNull(message = "A pessoa deve ser informada")
     
      @ManyToOne
      @JoinColumn(name = "id_da_pessoa",referencedColumnName = "id",nullable = false)
      @ForeignKey(name = "fk_pessoa_id")
       private Pessoa pessoa;
      
      @ManyToOne
      @JoinColumn(name = "id_tipo_endereco",referencedColumnName = "id",nullable = false)
      @ForeignKey(name = "fk_tipo_endereco_id")
      private TipoEndereco tipoEndereco;

    /**
     * @return the id
     */
   
   
   
    public Endereco() {
    }

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
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the tipoEndereco
     */
    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    /**
     * @param tipoEndereco the tipoEndereco to set
     */
    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }
   
   
    
    
    
    
    
}
