/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calculopoupanca.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC_LENOVO
 */
@Entity
@Table(name = "tb_planos_cp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planos.findAll", query = "SELECT p FROM Planos p")
    , @NamedQuery(name = "Planos.findByIdPlano", query = "SELECT p FROM Planos p WHERE p.idPlano = :idPlano")
    , @NamedQuery(name = "Planos.findByTxNmPlano", query = "SELECT p FROM Planos p WHERE p.txNmPlano = :txNmPlano")
    , @NamedQuery(name = "Planos.findByAtivoPlanos", query = "SELECT p FROM Planos p WHERE p.ativoPlanos = :ativoPlanos")})
public class Planos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plano")
    private Integer idPlano;
    @Basic(optional = false)
    @Column(name = "tx_nm_plano")
    private String txNmPlano;
    @Basic(optional = false)
    @Column(name = "ativo_planos")
    private int ativoPlanos;

    public Planos() {
    }

    public Planos(Integer idPlano) {
        this.idPlano = idPlano;
    }

    public Planos(Integer idPlano, String txNmPlano, int ativoPlanos) {
        this.idPlano = idPlano;
        this.txNmPlano = txNmPlano;
        this.ativoPlanos = ativoPlanos;
    }

    public Integer getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Integer idPlano) {
        this.idPlano = idPlano;
    }

    public String getTxNmPlano() {
        return txNmPlano;
    }

    public void setTxNmPlano(String txNmPlano) {
        this.txNmPlano = txNmPlano;
    }

    public int getAtivoPlanos() {
        return ativoPlanos;
    }

    public void setAtivoPlanos(int ativoPlanos) {
        this.ativoPlanos = ativoPlanos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlano != null ? idPlano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planos)) {
            return false;
        }
        Planos other = (Planos) object;
        if ((this.idPlano == null && other.idPlano != null) || (this.idPlano != null && !this.idPlano.equals(other.idPlano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.calculopoupanca.entity.Planos[ idPlano=" + idPlano + " ]";
    }
    
}
