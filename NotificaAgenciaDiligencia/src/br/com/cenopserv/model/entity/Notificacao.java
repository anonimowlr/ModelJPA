/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cenopserv.model.entity;

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

/**
 *
 * @author f5078775
 */
@Entity
@Table(name = "tb_prc_diligencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificacao.findAll", query = "SELECT n FROM Notificacao n")
    , @NamedQuery(name = "Notificacao.findByCodigo", query = "SELECT n FROM Notificacao n WHERE n.codigo = :codigo")
    , @NamedQuery(name = "Notificacao.findByAof", query = "SELECT n FROM Notificacao n WHERE n.aof = :aof")
    , @NamedQuery(name = "Notificacao.findByNpj", query = "SELECT n FROM Notificacao n WHERE n.npj = :npj")
    , @NamedQuery(name = "Notificacao.findByPrefAgencia", query = "SELECT n FROM Notificacao n WHERE n.prefAgencia = :prefAgencia")
    , @NamedQuery(name = "Notificacao.findByEmail", query = "SELECT n FROM Notificacao n WHERE n.email = :email")
    , @NamedQuery(name = "Notificacao.findByGsv", query = "SELECT n FROM Notificacao n WHERE n.gsv = :gsv")
    , @NamedQuery(name = "Notificacao.findByStatus", query = "SELECT n FROM Notificacao n WHERE n.status = :status")
    , @NamedQuery(name = "Notificacao.findByDtVenc", query = "SELECT n FROM Notificacao n WHERE n.dtVenc = :dtVenc")
    , @NamedQuery(name = "Notificacao.findByEtapa", query = "SELECT n FROM Notificacao n WHERE n.etapa = :etapa")
    , @NamedQuery(name = "Notificacao.findByDtEtpAtual", query = "SELECT n FROM Notificacao n WHERE n.dtEtpAtual = :dtEtpAtual")
    , @NamedQuery(name = "Notificacao.findByOcorrencia", query = "SELECT n FROM Notificacao n WHERE n.ocorrencia = :ocorrencia")
    , @NamedQuery(name = "Notificacao.findByAtividade", query = "SELECT n FROM Notificacao n WHERE n.atividade = :atividade")
    , @NamedQuery(name = "Notificacao.findByEquipe", query = "SELECT n FROM Notificacao n WHERE n.equipe = :equipe")
    , @NamedQuery(name = "Notificacao.findByGerente", query = "SELECT n FROM Notificacao n WHERE n.gerente = :gerente")
    , @NamedQuery(name = "Notificacao.findByFunciRespGsv", query = "SELECT n FROM Notificacao n WHERE n.funciRespGsv = :funciRespGsv")
    , @NamedQuery(name = "Notificacao.findByObs", query = "SELECT n FROM Notificacao n WHERE n.obs = :obs")
    , @NamedQuery(name = "Notificacao.findByDataLimRespAg", query = "SELECT n FROM Notificacao n WHERE n.dataLimRespAg = :dataLimRespAg")
    , @NamedQuery(name = "Notificacao.findByChaveFunciRespGsv", query = "SELECT n FROM Notificacao n WHERE n.chaveFunciRespGsv = :chaveFunciRespGsv")
    , @NamedQuery(name = "Notificacao.findByDataEnvioCorreio", query = "SELECT n FROM Notificacao n WHERE n.dataEnvioCorreio = :dataEnvioCorreio")
    , @NamedQuery(name = "Notificacao.findByFuncionarioRespEnvio", query = "SELECT n FROM Notificacao n WHERE n.funcionarioRespEnvio = :funcionarioRespEnvio")
    , @NamedQuery(name = "Notificacao.findByAgeDestinoSubsidio", query = "SELECT n FROM Notificacao n WHERE n.ageDestinoSubsidio = :ageDestinoSubsidio")
    , @NamedQuery(name = "Notificacao.findByChaveGerenteDestino", query = "SELECT n FROM Notificacao n WHERE n.chaveGerenteDestino = :chaveGerenteDestino")
    , @NamedQuery(name = "Notificacao.findBySituacaoSubsidio", query = "SELECT n FROM Notificacao n WHERE n.situacaoSubsidio = :situacaoSubsidio")})
public class Notificacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Column(name = "AOF")
    private String aof;
    @Column(name = "NPJ")
    private String npj;
    @Column(name = "Pref_Agencia")
    private String prefAgencia;
    @Column(name = "E_mail")
    private String email;
    @Column(name = "GSV")
    private Integer gsv;
    @Column(name = "Status")
    private String status;
    @Column(name = "Dt_Venc")
    @Temporal(TemporalType.DATE)
    private Date dtVenc;
    @Column(name = "Etapa")
    private String etapa;
    @Column(name = "Dt_Etp_Atual")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEtpAtual;
    @Column(name = "Ocorrencia")
    private String ocorrencia;
    @Column(name = "Atividade")
    private String atividade;
    @Column(name = "Equipe")
    private String equipe;
    @Column(name = "Gerente")
    private String gerente;
    @Column(name = "FUNCI_RESP_GSV")
    private String funciRespGsv;
    @Column(name = "OBS")
    private String obs;
    @Column(name = "DATA_LIM_RESP_AG")
    @Temporal(TemporalType.DATE)
    private Date dataLimRespAg;
    @Column(name = "CHAVE_FUNCI_RESP_GSV")
    private String chaveFunciRespGsv;
    @Column(name = "DATA_ENVIO_CORREIO")
    @Temporal(TemporalType.DATE)
    private Date dataEnvioCorreio;
    @Column(name = "FUNCIONARIO_RESP_ENVIO")
    private String funcionarioRespEnvio;
    @Column(name = "AGE_DESTINO_SUBSIDIO")
    private Integer ageDestinoSubsidio;
    @Column(name = "CHAVE_GERENTE_DESTINO")
    private String chaveGerenteDestino;
    @Column(name = "SITUACAO_SUBSIDIO")
    private String situacaoSubsidio;

    public Notificacao() {
    }

    public Notificacao(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getAof() {
        return aof;
    }

    public void setAof(String aof) {
        this.aof = aof;
    }

    public String getNpj() {
        return npj;
    }

    public void setNpj(String npj) {
        this.npj = npj;
    }

    public String getPrefAgencia() {
        return prefAgencia;
    }

    public void setPrefAgencia(String prefAgencia) {
        this.prefAgencia = prefAgencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGsv() {
        return gsv;
    }

    public void setGsv(Integer gsv) {
        this.gsv = gsv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDtVenc() {
        return dtVenc;
    }

    public void setDtVenc(Date dtVenc) {
        this.dtVenc = dtVenc;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Date getDtEtpAtual() {
        return dtEtpAtual;
    }

    public void setDtEtpAtual(Date dtEtpAtual) {
        this.dtEtpAtual = dtEtpAtual;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getFunciRespGsv() {
        return funciRespGsv;
    }

    public void setFunciRespGsv(String funciRespGsv) {
        this.funciRespGsv = funciRespGsv;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getDataLimRespAg() {
        return dataLimRespAg;
    }

    public void setDataLimRespAg(Date dataLimRespAg) {
        this.dataLimRespAg = dataLimRespAg;
    }

    public String getChaveFunciRespGsv() {
        return chaveFunciRespGsv;
    }

    public void setChaveFunciRespGsv(String chaveFunciRespGsv) {
        this.chaveFunciRespGsv = chaveFunciRespGsv;
    }

    public Date getDataEnvioCorreio() {
        return dataEnvioCorreio;
    }

    public void setDataEnvioCorreio(Date dataEnvioCorreio) {
        this.dataEnvioCorreio = dataEnvioCorreio;
    }

    public String getFuncionarioRespEnvio() {
        return funcionarioRespEnvio;
    }

    public void setFuncionarioRespEnvio(String funcionarioRespEnvio) {
        this.funcionarioRespEnvio = funcionarioRespEnvio;
    }

    public Integer getAgeDestinoSubsidio() {
        return ageDestinoSubsidio;
    }

    public void setAgeDestinoSubsidio(Integer ageDestinoSubsidio) {
        this.ageDestinoSubsidio = ageDestinoSubsidio;
    }

    public String getChaveGerenteDestino() {
        return chaveGerenteDestino;
    }

    public void setChaveGerenteDestino(String chaveGerenteDestino) {
        this.chaveGerenteDestino = chaveGerenteDestino;
    }

    public String getSituacaoSubsidio() {
        return situacaoSubsidio;
    }

    public void setSituacaoSubsidio(String situacaoSubsidio) {
        this.situacaoSubsidio = situacaoSubsidio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacao)) {
            return false;
        }
        Notificacao other = (Notificacao) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cenopserv.model.entity.Notificacao[ codigo=" + codigo + " ]";
    }
    
}
