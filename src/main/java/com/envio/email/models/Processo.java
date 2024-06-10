package com.envio.email.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
@Entity
@Data
public class Processo {
    @Id
    private Integer ID_processo;
    @Column(name = "codProcesso")
    private Integer codProcesso;
    @Column(name = "codEscritorio")
    private Integer codEscritorio;
    private String numeroProcesso;
    private Integer instancia;
    private String tribunal;
    private String siglaSistema;
    private String comarca;
    private String orgaoJulgador;
    private String tipoProcesso;
    private Date dataAudiencia;
    private Date dataDistribuicao;
    @Column(columnDefinition = "TEXT")
    private String assuntos;
    private String valorCausa;
    private String magistrado;
    private String cidade;
    private String uf;
    private String nomePesquisado;
    private LocalDate data_insercao;
    private String LocatorDB;
    private Integer deleted;
    private String status;

    public Integer getID_processo() {
        return ID_processo;
    }

    public void setID_processo(Integer ID_processo) {
        this.ID_processo = ID_processo;
    }

    public Integer getCodProcesso() {
        return codProcesso;
    }

    public void setCodProcesso(Integer codProcesso) {
        this.codProcesso = codProcesso;
    }

    public Integer getCodEscritorio() {
        return codEscritorio;
    }

    public void setCodEscritorio(Integer codEscritorio) {
        this.codEscritorio = codEscritorio;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public Integer getInstancia() {
        return instancia;
    }

    public void setInstancia(Integer instancia) {
        this.instancia = instancia;
    }

    public String getTribunal() {
        return tribunal;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }

    public String getSiglaSistema() {
        return siglaSistema;
    }

    public void setSiglaSistema(String siglaSistema) {
        this.siglaSistema = siglaSistema;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getOrgaoJulgador() {
        return orgaoJulgador;
    }

    public void setOrgaoJulgador(String orgaoJulgador) {
        this.orgaoJulgador = orgaoJulgador;
    }

    public String getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    public Date getDataAudiencia() {
        return dataAudiencia;
    }

    public void setDataAudiencia(Date dataAudiencia) {
        this.dataAudiencia = dataAudiencia;
    }

    public Date getDataDistribuicao() {
        return dataDistribuicao;
    }

    public void setDataDistribuicao(Date dataDistribuicao) {
        this.dataDistribuicao = dataDistribuicao;
    }

    public String getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(String assuntos) {
        this.assuntos = assuntos;
    }

    public String getValorCausa() {
        return valorCausa;
    }

    public void setValorCausa(String valorCausa) {
        this.valorCausa = valorCausa;
    }

    public void setValorDaCausa(String valorDaCausa) {
        this.valorCausa = valorDaCausa;
    }

    public String getMagistrado() {
        return magistrado;
    }

    public void setMagistrado(String magistrado) {
        this.magistrado = magistrado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNomePesquisado() {
        return nomePesquisado;
    }

    public void setNomePesquisado(String nomePesquisado) {
        this.nomePesquisado = nomePesquisado;
    }

    public LocalDate getData_insercao() {
        return data_insercao;
    }

    public void setData_insercao(LocalDate data_insercao) {
        this.data_insercao = data_insercao;
    }

    public String getLocatorDB() {
        return LocatorDB;
    }

    public void setLocatorDB(String locatorDB) {
        this.LocatorDB = locatorDB;
    }

    public Integer getDeleted() {
        return deleted;
    }
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
