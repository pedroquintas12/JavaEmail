package com.envio.email.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Cliente {


    @Id
    @Column(name = "ID_escritorios")
    private Long ID_escritorios;

    @Column(name = "cod_escritorio")
    private Integer codEscritorio;
    @Column(name = "cliente_VSAP")
    private String cliente_VSAP;

    private String emails;

    public Long getID_escritorios() {
        return ID_escritorios;
    }

    public void setID_escritorios(Long ID_escritorios) {
        this.ID_escritorios = ID_escritorios;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getCliente_VSAP() {
        return cliente_VSAP;
    }

    public void setCliente_VSAP(String cliente_VSAP) {
        this.cliente_VSAP = cliente_VSAP;
    }

    public Integer getCodEscritorio() {
        return codEscritorio;
    }

    public void setCod_escritorio(Integer codEscritorio) {
        this.codEscritorio = codEscritorio;
    }
}
