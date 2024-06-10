package com.envio.email.models;

import jakarta.persistence.*;

@Entity
public class Processo_autor {
    @ManyToOne
    @JoinColumn(name = "ID_processo")
    private Processo ID;
    @Id
    private int ID_autor;
    private int codPolo;
    private String nome;
    private String descricaoPolo;
    private String cnpj;
    private String cpf;

    public Processo getID() {
        return ID;
    }

    public void setID(Processo ID) {
        this.ID = ID;
    }

    public int getID_autor() {
        return ID_autor;
    }

    public void setID_autor(int ID_autor) {
        this.ID_autor = ID_autor;
    }

    public int getCodPolo() {
        return codPolo;
    }

    public void setCodPolo(int codPolo) {
        this.codPolo = codPolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoPolo() {
        return descricaoPolo;
    }

    public void setDescricaoPolo(String descricaoPolo) {
        this.descricaoPolo = descricaoPolo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
