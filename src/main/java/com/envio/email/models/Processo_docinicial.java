package com.envio.email.models;

import jakarta.persistence.*;

@Entity
public class Processo_docinicial {

    @ManyToOne
    @JoinColumn(name = "ID_processo")
    private Processo ID;
    @Id
    @Column(name = "ID_DocIncial")
    private Long ID_DocInicial;

    @Column(name = "linkDocumento", columnDefinition = "TEXT")
    private String linkDocInicial;

    @Column(name = "docPeticaoInicial")
    private Boolean docPeticaoInicial;

    public Long getID_DocInicial() {
        return ID_DocInicial;
    }

    public void setID_DocInicial(Long ID_DocInicial) {
        this.ID_DocInicial = ID_DocInicial;
    }

    public Processo getID() {
        return ID;
    }

    public void setID(Processo ID) {
        this.ID = ID;
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
