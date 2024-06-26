package com.envio.email.services;

import com.envio.email.config.MailConfig;
import com.envio.email.enums.StatusEmail;
import com.envio.email.models.EmailModel;
import com.envio.email.repositories.EmailRepository;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService  {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender MailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            MailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.S);
        }catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.E);
        }finally {
            return emailRepository.save(emailModel);
        }

    }


}
