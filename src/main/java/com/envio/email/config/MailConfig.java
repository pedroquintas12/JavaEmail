package com.envio.email.config;

import com.envio.email.models.Companies;
import com.envio.email.services.CompaniesSevice;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
public class MailConfig {

    private final CompaniesSevice companiesServices;

    private Map<Long, JavaMailSender> javaMailSenders;

    public MailConfig(CompaniesSevice companiesServices) {
        this.companiesServices = companiesServices;
        this.javaMailSenders = new HashMap<>();
    }

    @PostConstruct
    public void init() {
        javaMailSenders = companiesServices.findAll().stream().collect(Collectors.toMap(Companies::getId, this::createMailSender));
    }

    @Bean
    public JavaMailSender defaultMailSender() {
        return createMailSender(companiesServices.findAll().get(0));
    }

    private JavaMailSender createMailSender(Companies c) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(c.getSmtpHost());
        mailSender.setPort(c.getSmtpPort());
        mailSender.setUsername(c.getSmtpUsername());
        mailSender.setPassword(c.getSmtpPassword());

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");

        mailSender.setJavaMailProperties(props);
        return mailSender;
    }

    public JavaMailSender getMailSenderForCompany(Long companyId) {
        return javaMailSenders.get(companyId);
    }
}
