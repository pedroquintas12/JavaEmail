package com.envio.email.dtos;

import com.envio.email.models.Processo;
import com.envio.email.models.Processo_autor;
import com.envio.email.models.Processo_reu;

import java.util.List;

public class ProcessoDTO {

    private Integer ID_Processo;
    private List<Processo_autor> autores;
    private List<Processo_reu> reus;
    private String localizador;

    public ProcessoDTO() {
    }

    public ProcessoDTO(Integer idProcesso, List<Processo_autor> autores, List<Processo_reu> reus) {
        this.ID_Processo = Math.toIntExact(idProcesso);
        this.autores = autores;
        this.reus = reus;
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
}
