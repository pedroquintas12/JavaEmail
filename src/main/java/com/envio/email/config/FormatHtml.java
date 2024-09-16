package com.envio.email.config;

import com.envio.email.dtos.ProcessoDTO;
import com.envio.email.models.Companies;
import com.envio.email.models.Processo;
import lombok.var;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class FormatHtml {


    private final TemplateEngine templateEngine;

    public FormatHtml(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }

    public String makeToHtml(Companies companies, ProcessoDTO processoDTO, <Processo> payload){
        var context = new Context();
        var offices = ProcessoDTO.
    }

}
