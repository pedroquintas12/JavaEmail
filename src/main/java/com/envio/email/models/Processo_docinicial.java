package com.envio.email.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Processo_docinicial {
    @Id
    private int ID_DocInicial;
    private String linkDocInicial;
    private Boolean docPeticaoInicial;

    public int getID_DocInicial() {
        return ID_DocInicial;
    }

    public void setID_DocInicial(int ID_DocInicial) {
        this.ID_DocInicial = ID_DocInicial;
    }

    public String getLinkDocInicial() {
        return linkDocInicial;
    }

    public void setLinkDocInicial(String linkDocInicial) {
        this.linkDocInicial = linkDocInicial;
    }

    public Boolean getDocPeticaoInicial() {
        return docPeticaoInicial;
    }

    public void setDocPeticaoInicial(Boolean docPeticaoInicial) {
        this.docPeticaoInicial = docPeticaoInicial;
    }
}
