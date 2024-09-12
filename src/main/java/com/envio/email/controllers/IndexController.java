package com.envio.email.controllers;

import com.envio.email.dtos.ProcessoDTO;

import com.envio.email.models.Cliente;
import com.envio.email.models.Processo;
import com.envio.email.models.Processo_docinicial;
import com.envio.email.services.AutorReuService;
import com.envio.email.services.ClienteService;
import com.envio.email.services.CompaniesSevice;
import com.envio.email.services.DocInicialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class IndexController {

    private final AutorReuService autorReuService;
    private final ClienteService clienteService;
    private final CompaniesSevice companiesSevice;
    private final DocInicialService docInicialService;

    public IndexController(AutorReuService autorReuService, ClienteService clienteService, CompaniesSevice companiesSevice, DocInicialService docInicialService) {
        this.autorReuService = autorReuService;
        this.clienteService = clienteService;
        this.companiesSevice = companiesSevice;
        this.docInicialService = docInicialService;

    }

    @GetMapping("/")
    public String DadosProcesso(Model model, @RequestParam(required = false) String status, @RequestParam(required = false) Integer codEscritorio) {
        List<ProcessoDTO> autorReuDTOList = autorReuService.buscarAutoresReusPorParametros("P", 1303);

        if (!autorReuDTOList.isEmpty()) {
            Integer codEscritorioDoDTO = autorReuDTOList.get(0).getCodEscritorio();
            List<Cliente>clientes = clienteService.BuscarPorEscritorio(codEscritorioDoDTO);
            model.addAttribute("cliente", clientes);
        }
        //Limita os links exibidos em tela
        List<Processo_docinicial> links = autorReuDTOList.get(0).getLink();
        var limiteLinks = 5;

        if (links.size()> limiteLinks){
                links = links.subList(0, limiteLinks);
        }

        model.addAttribute("Link", links);
        model.addAttribute("urlThumbnail", companiesSevice.findAll().get(0).getUrlThumbnail() );
        model.addAttribute("localizador", UUID.randomUUID().toString());
        model.addAttribute("listprocessos", autorReuDTOList);

        return "/distribuição-notifications";
    }
}

