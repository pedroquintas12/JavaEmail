package com.envio.email.models;

import com.envio.email.core.AbstractPersistableCustom;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.AbstractPersistable;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

// * JPA
@Entity
@Table(name = "companies")
@AttributeOverride(name = "id", column = @Column(name = "id_companies"))
@Where(clause = "deleted=0")
public class Companies extends AbstractPersistableCustom<Long> {

    @Column(name = "solucionare_distribuicao_token")
    private String SolucionareDistribuicaoToken;

    @Column(name = "solucionare_distribuicao_nome_relacional")
    private String solucionareDistribuicaoNomeRelacional;

    @Column(name = "solucionare_distribuicao_url")
    private String solucionareDistribuicaoUrl;

    @Column(name = "solucionare_distribuicao_confirmardados_url")
    private String solucionareDistribuicaoConfirmardadosUrl;

    @Column(name = "smtp_host")
    private String smtpHost;

    @Column(name = "smtp_port")
    private Integer smtpPort;

    @Column(name = "smtp_username")
    private String smtpUsername;

    @Column(name = "smtp_password")
    private String smtpPassword;

    public String getSolucionareDistribuicaoNomeRelacional() {
        return solucionareDistribuicaoNomeRelacional;
    }

    public void setSolucionareDistribuicaoNomeRelacional(String solucionareDistribuicaoNomeRelacional) {
        this.solucionareDistribuicaoNomeRelacional = solucionareDistribuicaoNomeRelacional;
    }

    public String getSolucionareDistribuicaoToken() {
        return SolucionareDistribuicaoToken;
    }

    public void setSolucionareDistribuicaoToken(String solucionareDistribuicaoToken) {
        SolucionareDistribuicaoToken = solucionareDistribuicaoToken;
    }

    public String getSolucionareDistribuicaoConfirmardadosUrl() {
        return solucionareDistribuicaoConfirmardadosUrl;
    }

    public void setSolucionareDistribuicaoConfirmardadosUrl(String solucionareDistribuicaoConfirmardadosUrl) {
        this.solucionareDistribuicaoConfirmardadosUrl = solucionareDistribuicaoConfirmardadosUrl;
    }

    public String getSolucionareDistribuicaoUrl() {
        return solucionareDistribuicaoUrl;
    }

    public void setSolucionareDistribuicaoUrl(String solucionareDistribuicaoUrl) {
        this.solucionareDistribuicaoUrl = solucionareDistribuicaoUrl;
    }

    public Integer getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(Integer smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpUsername() {
        return smtpUsername;
    }

    public void setSmtpUsername(String smtpUsername) {
        this.smtpUsername = smtpUsername;
    }

    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }
}
