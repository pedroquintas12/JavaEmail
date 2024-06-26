package com.envio.email.models;

import com.envio.email.core.AbstractPersistableCustom;
import com.envio.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.LocalDateTime;
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Data
@Entity
@Table(name="email")
@AttributeOverride(name = "id", column = @Column(name = "id_email"))
@Where(clause = "deleted=0")
public class EmailModel extends AbstractPersistableCustom<Long> implements Serializable{

    private static final long serialVersionUID = 1L;

    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String Text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;


    public String getOwnerRef() {
        return ownerRef;
    }

    public void setOwnerRef(String ownerRef) {
        this.ownerRef = ownerRef;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}
