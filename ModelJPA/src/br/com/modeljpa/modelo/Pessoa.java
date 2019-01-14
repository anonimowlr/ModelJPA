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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author PC_LENOVO
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Pessoa implements  Serializable{
   
    @Id
    @SequenceGenerator(name = "seq_pessoa",sequenceName = "pessoa_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "nome", length = 50, nullable = false)
    @NotNull(message = "O nome nao pode ser nulo")
    @NotBlank(message = "O nome nao pode ser  em branco")
    @Length(max = 50,message = "O nome nao pode ter mais de {max} caracteres")
    private String nome;
     @Column(name = "emal", length = 50, nullable = false)
    @NotNull(message = "O email nao pode ser nulo")
    @NotBlank(message = "O email nao pode ser  em branco")
    @Length(max = 50,message = "O email nao pode ter mais de {max} caracteres")
    private String email;
      @Column(name = "telefone", length = 50, nullable = false)
    @NotNull(message = "O telefone nao pode ser nulo")
    @NotBlank(message = "O telenone nao pode ser  em branco")
    @Length(max = 14,message = "O telefone nao pode ter mais de {max} caracteres")
    private String telefone;
      
      
      List<Endereco> enderecos = new ArrayList<>();

    public Pessoa() {
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
