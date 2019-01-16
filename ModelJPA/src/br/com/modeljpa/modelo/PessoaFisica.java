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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author PC_LENOVO
 */
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica  extends Pessoa implements Serializable{
    
   @Column(name = "RG", length = 10, nullable = false)
    @NotNull(message = "O RG nao pode ser nulo")
    @NotBlank(message = "O RG nao pode ser  em branco")
    @Length(max = 10,message = "O rg nao pode ter mais de {max} caracteres") 
  private String rg;
    @Column(name = "CPF", length = 14, nullable = false)
    @NotNull(message = "O CPF nao pode ser nulo")
    @NotBlank(message = "O CPF nao pode ser  em branco")
    @Length(max = 14 ,message = "O CPF nao pode ter mais de {max} caracteres") 
    @CPF(message = "CPF invalido")
  private String cpf;
    
@NotNull(message = "O nascimento nao pode ser nulo")
@Column(name = "nascimento", nullable = false)
@Temporal(TemporalType.DATE)
  private Calendar nascimento;
 @Column(name = "nome_usuario", length = 10, nullable = false, unique = true)
    @NotNull(message = "O nome  de usuario nao pode ser nulo")
    @NotBlank(message = "O nome de usuario  nao pode ser  em branco")
    @Length(max = 10,message = "O nome de usuario  nao pode ter mais de {max} caracteres") 
  private String nomeUsuario;
 @Column(name = "senha", length = 20, nullable = false)
    @NotNull(message = "A senha   usuario nao pode ser nula")
    @NotBlank(message = "A senha   nao pode ser  em branco")
    @Length(max = 20,message = "A senha  nao pode ter mais de {max} caracteres") 
  private String senha;
 
 @ManyToMany(fetch = FetchType.LAZY) // lazy carregamento tardio
 @JoinTable(name = "tb_desejos",joinColumns = @JoinColumn(name = "pessoa_fisica",referencedColumnName = "id",nullable = false),
         inverseJoinColumns = @JoinColumn(name = "produto",referencedColumnName = "id",nullable = false),uniqueConstraints = {@UniqueConstraint(columnNames = {"pessoa_fisica","produto"})})
 private List<Produto> desejos = new ArrayList<>();

    public List<Produto> getDesejos() {
        return desejos;
    }

    public void setDesejos(List<Produto> desejos) {
        this.desejos = desejos;
    }
 


    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nascimento
     */
    public Calendar getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
