package com.envio.email.controllers;

import com.envio.email.dtos.ProcessoDTO;

import com.envio.email.models.Cliente;
import com.envio.email.models.Companies;
import com.envio.email.repositories.ClienteRepository;
import com.envio.email.services.AutorReuService;
import com.envio.email.services.ClienteService;
import com.envio.email.services.CompaniesSevice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    private final AutorReuService autorReuService;
    private final ClienteService clienteService;
    private final CompaniesSevice companiesSevice;

    public IndexController(AutorReuService autorReuService, ClienteService clienteService, CompaniesSevice companiesSevice) {
        this.autorReuService = autorReuService;
        this.clienteService = clienteService;
        this.companiesSevice = companiesSevice;
    }

    @GetMapping("/")
    public String DadosProcesso(Model model, @RequestParam(required = false) String status, @RequestParam(required = false) Integer codEscritorio) {

        List<ProcessoDTO> autorReuDTOList = autorReuService.buscarAutoresReusPorParametros("P", 1165);
        if (!autorReuDTOList.isEmpty()) {
            Integer codEscritorioDoDTO = autorReuDTOList.get(0).getCodEscritorio();
            List<Cliente>clientes = clienteService.BuscarPorEscritorio(codEscritorioDoDTO);
            model.addAttribute("cliente", clientes);
        }
        model.addAttribute("urlThumbnail",companiesSevice.findAll().get(0).getUrlThumbnail() );
        model.addAttribute("localizador", UUID.randomUUID().toString());
        model.addAttribute("listprocessos", autorReuDTOList);

        return "/distribuição-notifications";
    }
}

