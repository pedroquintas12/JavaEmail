package com.envio.email.config;

import com.envio.email.core.NumberUtils;
import com.envio.email.core.StringUtils;
import com.envio.email.models.Companies;
import com.envio.email.services.CompaniesSevice;
import jakarta.annotation.PostConstruct;
import lombok.Builder;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Getter
@Builder
@Configuration
public class MailConfig {

    private final String loggerIdentity = this.getClass().getName();

    private final CompaniesSevice companiesServices;

    private Map<Long, JavaMailSender> javaMailSenders;

    @PostConstruct
    public void init() {
        var loggerIdentityFull = loggerIdentity + ".javaMailCustomConfig()";
        this.javaMailSenders = companiesServices.findAll().stream().collect(Collectors.toMap(
                Companies::getId, c -> {
                    if (!StringUtils.stringIsNullOrEmpty(c.getSmtpUsername())) {
                        try {
                            var mailSender = new JavaMailSenderImpl();
                            mailSender.setHost(StringUtils.defaultIfEmpty(c.getSmtpHost(), ""));
                            mailSender.setPort(NumberUtils.defaultIfEmpty(c.getSmtpPort(), 587));
                            mailSender.setUsername(StringUtils.defaultIfEmpty(c.getSmtpUsername(), ""));
                            mailSender.setPassword(StringUtils.defaultIfEmpty(c.getSmtpPassword(), ""));
                            Properties props = mailSender.getJavaMailProperties();
                            props.put("mail.transport.protocol", "smtp");
                            props.put("mail.smtp.auth", "true");
                            props.put("mail.smtp.starttls.enable", "true");
                            props.put("mail.smtp.starttls.required", "true");
                            return mailSender;
                        } catch (Exception e) {
                            Logger.getLogger(loggerIdentityFull)
                                    .log(Level.SEVERE, "Erro on configure e-mail sender, reason: " + e.getLocalizedMessage(), e);
                        }
                    }
                    return null;
                }
        ));


    }
}