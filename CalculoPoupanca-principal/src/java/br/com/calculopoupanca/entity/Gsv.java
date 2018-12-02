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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC_LENOVO
 */
@Entity
@Table(name = "view_tb_gsv_total_serv_jud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gsv.findAll", query = "SELECT g FROM Gsv g")
    , @NamedQuery(name = "Gsv.findByCdPrc", query = "SELECT g FROM Gsv g WHERE g.cdPrc = :cdPrc")
    , @NamedQuery(name = "Gsv.findByNmAgrupPrc", query = "SELECT g FROM Gsv g WHERE g.nmAgrupPrc = :nmAgrupPrc")
    , @NamedQuery(name = "Gsv.findByNmTipAtvd", query = "SELECT g FROM Gsv g WHERE g.nmTipAtvd = :nmTipAtvd")
    , @NamedQuery(name = "Gsv.findByCdUsuFun", query = "SELECT g FROM Gsv g WHERE g.cdUsuFun = :cdUsuFun")
    , @NamedQuery(name = "Gsv.findByNmFasePrc", query = "SELECT g FROM Gsv g WHERE g.nmFasePrc = :nmFasePrc")
    , @NamedQuery(name = "Gsv.findByDtEntdPrc", query = "SELECT g FROM Gsv g WHERE g.dtEntdPrc = :dtEntdPrc")
    , @NamedQuery(name = "Gsv.findByDtSaidPrc", query = "SELECT g FROM Gsv g WHERE g.dtSaidPrc = :dtSaidPrc")
    , @NamedQuery(name = "Gsv.findByCdEtp", query = "SELECT g FROM Gsv g WHERE g.cdEtp = :cdEtp")
    , @NamedQuery(name = "Gsv.findByIdentific1", query = "SELECT g FROM Gsv g WHERE g.identific1 = :identific1")
    , @NamedQuery(name = "Gsv.findByIdentific2", query = "SELECT g FROM Gsv g WHERE g.identific2 = :identific2")
    , @NamedQuery(name = "Gsv.findByIdentific3", query = "SELECT g FROM Gsv g WHERE g.identific3 = :identific3")
    , @NamedQuery(name = "Gsv.findByCdTipAtvd", query = "SELECT g FROM Gsv g WHERE g.cdTipAtvd = :cdTipAtvd")
    , @NamedQuery(name = "Gsv.findByCdClassePrc", query = "SELECT g FROM Gsv g WHERE g.cdClassePrc = :cdClassePrc")
    , @NamedQuery(name = "Gsv.findByNmEtp", query = "SELECT g FROM Gsv g WHERE g.nmEtp = :nmEtp")
    , @NamedQuery(name = "Gsv.findByNmTipPrc", query = "SELECT g FROM Gsv g WHERE g.nmTipPrc = :nmTipPrc")
    , @NamedQuery(name = "Gsv.findByNmClassePrc", query = "SELECT g FROM Gsv g WHERE g.nmClassePrc = :nmClassePrc")})
public class Gsv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "CD_PRC")
    @Id
    private int cdPrc;
    @Column(name = "NM_AGRUP_PRC")
    private String nmAgrupPrc;
    @Column(name = "NM_TIP_ATVD")
    private String nmTipAtvd;
    @Column(name = "CD_USU_FUN")
    private String cdUsuFun;
    @Column(name = "NM_FASE_PRC")
    private String nmFasePrc;
    @Column(name = "DT_ENTD_PRC")
    @Temporal(TemporalType.DATE)
    private Date dtEntdPrc;
    @Column(name = "DT_SAID_PRC")
    @Temporal(TemporalType.DATE)
    private Date dtSaidPrc;
    @Column(name = "CD_ETP")
    private Integer cdEtp;
    @Column(name = "IDENTIFIC1")
    private String identific1;
    @Column(name = "IDENTIFIC2")
    private String identific2;
    @Column(name = "IDENTIFIC3")
    private String identific3;
    @Column(name = "CD_TIP_ATVD")
    private Integer cdTipAtvd;
    @Column(name = "CD_CLASSE_PRC")
    private Integer cdClassePrc;
    @Column(name = "NM_ETP")
    private String nmEtp;
    @Column(name = "NM_TIP_PRC")
    private String nmTipPrc;
    @Column(name = "NM_CLASSE_PRC")
    private String nmClassePrc;

    public Gsv() {
    }

    public int getCdPrc() {
        return cdPrc;
    }

    public void setCdPrc(int cdPrc) {
        this.cdPrc = cdPrc;
    }

    public String getNmAgrupPrc() {
        return nmAgrupPrc;
    }

    public void setNmAgrupPrc(String nmAgrupPrc) {
        this.nmAgrupPrc = nmAgrupPrc;
    }

    public String getNmTipAtvd() {
        return nmTipAtvd;
    }

    public void setNmTipAtvd(String nmTipAtvd) {
        this.nmTipAtvd = nmTipAtvd;
    }

    public String getCdUsuFun() {
        return cdUsuFun;
    }

    public void setCdUsuFun(String cdUsuFun) {
        this.cdUsuFun = cdUsuFun;
    }

    public String getNmFasePrc() {
        return nmFasePrc;
    }

    public void setNmFasePrc(String nmFasePrc) {
        this.nmFasePrc = nmFasePrc;
    }

    public Date getDtEntdPrc() {
        return dtEntdPrc;
    }

    public void setDtEntdPrc(Date dtEntdPrc) {
        this.dtEntdPrc = dtEntdPrc;
    }

    public Date getDtSaidPrc() {
        return dtSaidPrc;
    }

    public void setDtSaidPrc(Date dtSaidPrc) {
        this.dtSaidPrc = dtSaidPrc;
    }

    public Integer getCdEtp() {
        return cdEtp;
    }

    public void setCdEtp(Integer cdEtp) {
        this.cdEtp = cdEtp;
    }

    public String getIdentific1() {
        return identific1;
    }

    public void setIdentific1(String identific1) {
        this.identific1 = identific1;
    }

    public String getIdentific2() {
        return identific2;
    }

    public void setIdentific2(String identific2) {
        this.identific2 = identific2;
    }

    public String getIdentific3() {
        return identific3;
    }

    public void setIdentific3(String identific3) {
        this.identific3 = identific3;
    }

    public Integer getCdTipAtvd() {
        return cdTipAtvd;
    }

    public void setCdTipAtvd(Integer cdTipAtvd) {
        this.cdTipAtvd = cdTipAtvd;
    }

    public Integer getCdClassePrc() {
        return cdClassePrc;
    }

    public void setCdClassePrc(Integer cdClassePrc) {
        this.cdClassePrc = cdClassePrc;
    }

    public String getNmEtp() {
        return nmEtp;
    }

    public void setNmEtp(String nmEtp) {
        this.nmEtp = nmEtp;
    }

    public String getNmTipPrc() {
        return nmTipPrc;
    }

    public void setNmTipPrc(String nmTipPrc) {
        this.nmTipPrc = nmTipPrc;
    }

    public String getNmClassePrc() {
        return nmClassePrc;
    }

    public void setNmClassePrc(String nmClassePrc) {
        this.nmClassePrc = nmClassePrc;
    }
    
}
