/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calculopoupanca.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author f5078775
 */
@Entity
@Table(name = "view_tb_gsv_total_serv_jud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gsv.findAll", query = "SELECT g FROM Gsv g")
    , @NamedQuery(name = "Gsv.findByProtocolo", query = "SELECT g FROM Gsv g WHERE g.protocolo = :protocolo")
    , @NamedQuery(name = "Gsv.findByCdPrfUnd", query = "SELECT g FROM Gsv g WHERE g.cdPrfUnd = :cdPrfUnd")
    , @NamedQuery(name = "Gsv.findByProcesso", query = "SELECT g FROM Gsv g WHERE g.processo = :processo")
    , @NamedQuery(name = "Gsv.findByAtividade", query = "SELECT g FROM Gsv g WHERE g.atividade = :atividade")
    , @NamedQuery(name = "Gsv.findByDataEntrada", query = "SELECT g FROM Gsv g WHERE g.dataEntrada = :dataEntrada")
    , @NamedQuery(name = "Gsv.findByIdentificador1", query = "SELECT g FROM Gsv g WHERE g.identificador1 = :identificador1")
    , @NamedQuery(name = "Gsv.findByIdentificador2", query = "SELECT g FROM Gsv g WHERE g.identificador2 = :identificador2")
    , @NamedQuery(name = "Gsv.findByIdentificador3", query = "SELECT g FROM Gsv g WHERE g.identificador3 = :identificador3")
    , @NamedQuery(name = "Gsv.findByCdTipAtvd", query = "SELECT g FROM Gsv g WHERE g.cdTipAtvd = :cdTipAtvd")
    , @NamedQuery(name = "Gsv.findByCdClassePrc", query = "SELECT g FROM Gsv g WHERE g.cdClassePrc = :cdClassePrc")
    , @NamedQuery(name = "Gsv.findByEtapa", query = "SELECT g FROM Gsv g WHERE g.etapa = :etapa")
    , @NamedQuery(name = "Gsv.findByTipoProcesso", query = "SELECT g FROM Gsv g WHERE g.tipoProcesso = :tipoProcesso")
    , @NamedQuery(name = "Gsv.findByNmClassePrc", query = "SELECT g FROM Gsv g WHERE g.nmClassePrc = :nmClassePrc")})
public class Gsv implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROTOCOLO")
    private int protocolo;
    @Basic(optional = false)
    @Column(name = "CD_PRF_UND")
    private int cdPrfUnd;
    @Column(name = "PROCESSO")
    private String processo;
    @Column(name = "ATIVIDADE")
    private String atividade;
    @Basic(optional = false)
    
    @Column(name = "DATA_ENTRADA")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataEntrada;
    @Column(name = "IDENTIFICADOR1")
    private String identificador1;
    @Column(name = "IDENTIFICADOR2")
    private String identificador2;
    @Column(name = "IDENTIFICADOR3")
    private String identificador3;
    @Basic(optional = false)
    @Column(name = "CD_TIP_ATVD")
    private int cdTipAtvd;
    @Column(name = "CD_CLASSE_PRC")
    private Integer cdClassePrc;
    @Column(name = "ETAPA")
    private String etapa;
    @Column(name = "TIPO_PROCESSO")
    private String tipoProcesso;
    @Column(name = "NM_CLASSE_PRC")
    private String nmClassePrc;

    public Gsv() {
    }

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public int getCdPrfUnd() {
        return cdPrfUnd;
    }

    public void setCdPrfUnd(int cdPrfUnd) {
        this.cdPrfUnd = cdPrfUnd;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getIdentificador1() {
        return identificador1;
    }

    public void setIdentificador1(String identificador1) {
        this.identificador1 = identificador1;
    }

    public String getIdentificador2() {
        return identificador2;
    }

    public void setIdentificador2(String identificador2) {
        this.identificador2 = identificador2;
    }

    public String getIdentificador3() {
        return identificador3;
    }

    public void setIdentificador3(String identificador3) {
        this.identificador3 = identificador3;
    }

    public int getCdTipAtvd() {
        return cdTipAtvd;
    }

    public void setCdTipAtvd(int cdTipAtvd) {
        this.cdTipAtvd = cdTipAtvd;
    }

    public Integer getCdClassePrc() {
        return cdClassePrc;
    }

    public void setCdClassePrc(Integer cdClassePrc) {
        this.cdClassePrc = cdClassePrc;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    public String getNmClassePrc() {
        return nmClassePrc;
    }

    public void setNmClassePrc(String nmClassePrc) {
        this.nmClassePrc = nmClassePrc;
    }
    
}
