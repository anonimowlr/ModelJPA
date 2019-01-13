package br.com.modeljpa.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "pais")
public class Pais implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_pais", sequenceName = "seq_pais_id" , allocationSize = 1)
    @GeneratedValue(generator = "seq_pais",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    
    @Column(name = "nome", nullable = false,length = 50)
    @Length (max = 50,message = "O nome não pode ter mais {max} caracteres")
    @NotBlank(message = "O nome deve ser informado")
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;
    @Column(name="iso",nullable = false,length = 3)
     @Length (max = 3,message = "O ISO não pode ter mais {max} caracteres")
    @NotBlank(message = "O Iso deve ser informado")
    @NotNull(message = "O Iso não pode ser nulo")
    private String iso;

    public Pais() {
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
     * @return the iso
     */
    public String getIso() {
        return iso;
    }

    /**
     * @param iso the iso to set
     */
    public void setIso(String iso) {
        this.iso = iso;
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
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
