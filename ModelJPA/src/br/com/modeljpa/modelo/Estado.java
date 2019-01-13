package br.com.modeljpa.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Estado implements Serializable {
    
    
    @Id
    @SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_estado",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "nome" ,length = 50, nullable = false)
    @NotBlank(message = "O nome deve ser informado")
    @NotNull(message = "O nome nao pode ser nulo  ")
    @Length(max = 50,message = "O nome nao pode ter mais de {max} caracteres")
    private String  nome;
     @Column(name = "uf " ,length = 50, nullable = false)
    @NotBlank(message = "O uf deve ser informada")
    @NotNull(message = "A  uf nao pode ser nuloa ")
    @Length(max = 2,message = "A uf nao pode ter mais de {max} caracteres")
    private String uf;
     
     @NotNull(message = "O pais deve ser informado")
     @ManyToOne
     @JoinColumn(name = "pais_id",referencedColumnName = "id",nullable = false)
   
    private Pais pais;

    public Estado() {
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
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the pais
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
    
    
    
    
    
    
}
