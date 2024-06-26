package com.envio.email.dtos;

import com.envio.email.models.Processo;
import com.envio.email.models.Processo_autor;
import com.envio.email.models.Processo_reu;
import jakarta.persistence.Column;

import java.sql.Date;
import java.util.List;

public class ProcessoDTO {

    private Integer ID_Processo;


    private List<Processo_autor> autores;
    private List<Processo_reu> reus;
    private String localizador;
    @Column(name = "codEscritorio")
    private Integer codEscritorio;
    private String numeroProcesso;
    private Integer instancia;
    private String tribunal;
    private String siglaSistema;
    private String comarca;
    private String orgaoJulgador;
    private Date dataDistribuicao;
    private String cidade;
    private String uf;



    public ProcessoDTO() {
    }

    public ProcessoDTO(Integer idProcesso, List<Processo_autor> autores, List<Processo_reu> reus, Integer codEscritorio, String numeroProcesso,
                       Integer instancia, String tribunal, String siglaSistema, String comarca, String orgaoJulgador, Date dataDistribuicao, String cidade,
                        String uf, String localizador) {
        this.ID_Processo = Math.toIntExact(idProcesso);
        this.autores = autores;
        this.reus = reus;
        this.cidade = cidade;
        this.codEscritorio = codEscritorio;
        this.comarca = comarca;
        this.dataDistribuicao = dataDistribuicao;
        this.instancia = instancia;
        this.numeroProcesso = numeroProcesso;
        this.localizador= localizador;
        this.orgaoJulgador = orgaoJulgador;
        this.siglaSistema = siglaSistema;
        this.tribunal= tribunal;
        this.uf = uf;

    }

    public Integer getID_Processo() {
        return ID_Processo;
    }

    public void setID_Processo(Integer ID_Processo) {
        this.ID_Processo = ID_Processo;
    }

    public List<Processo_autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Processo_autor> autores) {
        this.autores = autores;
    }

    public List<Processo_reu> getReus() {
        return reus;
    }

    public void setReus(List<Processo_reu> reus) {
        this.reus = reus;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public Integer getCodEscritorio() {
        return codEscritorio;
    }

    public void setCodEscritorio(Integer codEscritorio) {
        this.codEscritorio = codEscritorio;
    }


    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getDataDistribuicao(Date dataDistribuicao) {
        return this.dataDistribuicao;
    }

    public void setDataDistribuicao(Date dataDistribuicao) {
        this.dataDistribuicao = dataDistribuicao;
    }

    public String getOrgaoJulgador() {
        return orgaoJulgador;
    }

    public void setOrgaoJulgador(String orgaoJulgador) {
        this.orgaoJulgador = orgaoJulgador;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getSiglaSistema() {
        return siglaSistema;
    }

    public void setSiglaSistema(String siglaSistema) {
        this.siglaSistema = siglaSistema;
    }

    public String getTribunal() {
        return tribunal;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }

    public Integer getInstancia() {
        return instancia;
    }

    public void setInstancia(Integer instancia) {
        this.instancia = instancia;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }
}
