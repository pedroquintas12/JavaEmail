package com.envio.email.controllers;

import com.envio.email.dtos.ProcessoDTO;

import com.envio.email.models.*;
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

    public IndexController(AutorReuService autorReuService, ClienteService clienteService,
                           CompaniesSevice companiesSevice, DocInicialService docInicialService) {
        this.autorReuService = autorReuService;
        this.clienteService = clienteService;
        this.companiesSevice = companiesSevice;
        this.docInicialService = docInicialService;

    }

    @GetMapping("/")
    public String DadosProcesso(Model model, @RequestParam(required = false) String status, @RequestParam(required = false) Integer codEscritorio) {
        List<ProcessoDTO> autorReuDTOList = autorReuService.buscarAutoresReusPorParametros("P", 1165);
        var limiteLinks = 5;
        var limitepessoas = 1;

        if (!autorReuDTOList.isEmpty()) {
            Integer codEscritorioDoDTO = autorReuDTOList.get(0).getCodEscritorio();
            List<Cliente>clientes = clienteService.BuscarPorEscritorio(codEscritorioDoDTO);
            model.addAttribute("cliente", clientes);
        }

        //Limita os links exibidos em tela
        List<Processo_docinicial> links = autorReuDTOList.get(0).getLink();

        if (links.size()> limiteLinks){
                links = links.subList(0, limiteLinks);
        }
        List<Processo_reu> Reu = autorReuDTOList.get(0).getReus();
        List<Processo_autor> Autor = autorReuDTOList.get(0).getAutores();
        if (Reu.size() > limitepessoas || Autor.size()>limitepessoas ) {
            Reu = Reu.subList(0, limitepessoas);
            Autor = Autor.subList(0, limitepessoas);
        }
        model.addAttribute("Link", links);
        model.addAttribute("Reu",Reu);
        model.addAttribute("Autor", Autor);
        model.addAttribute("urlThumbnail", companiesSevice.findAll().get(0).getUrlThumbnail() );
        model.addAttribute("localizador", UUID.randomUUID().toString());
        model.addAttribute("listprocessos", autorReuDTOList);

        return "/distribuição-notifications";
    }
}

