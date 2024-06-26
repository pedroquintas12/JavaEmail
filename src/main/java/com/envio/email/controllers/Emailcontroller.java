package com.envio.email.controllers;

import com.envio.email.dtos.EmailDto;
import com.envio.email.models.EmailModel;
import com.envio.email.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Emailcontroller {

    @Autowired
    EmailService emailService;

    @PostMapping("/seding-email")
    public ResponseEntity<EmailModel> sendingEmail (@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto,emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);

    }

}
