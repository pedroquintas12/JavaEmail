package com.envio.email.controllers;

import com.envio.email.dtos.ProcessoDTO;

import com.envio.email.models.Processo;
import com.envio.email.services.AutorReuService;
import com.envio.email.services.ProcessoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    private final AutorReuService autorReuService;

    public IndexController(AutorReuService autorReuService) {
        this.autorReuService = autorReuService;
    }

    @GetMapping("/")
    public String DadosProcesso(Model model, @RequestParam(required = false) String status, @RequestParam(required = false) Integer codEscritorio) {
        List<ProcessoDTO> autorReuDTOList = autorReuService.buscarAutoresReusPorParametros("P", 495);
        model.addAttribute("listprocessos", autorReuDTOList);

        return "/distribuição-notifications";
    }
}

