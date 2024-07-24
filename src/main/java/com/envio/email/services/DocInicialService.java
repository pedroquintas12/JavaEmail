package com.envio.email.services;

import com.envio.email.models.Processo;
import com.envio.email.models.Processo_docinicial;
import com.envio.email.repositories.DocInicialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocInicialService {

    @Autowired
    DocInicialRepository docInicialRepository;

    public List<String> BuscarLinks(Processo processo){
        List<Processo_docinicial> Links = docInicialRepository.findByIDAndDocPeticaoInicial(processo, false);
        return Links.stream().map(Processo_docinicial::getLinkDocInicial).collect(Collectors.toList());
    }



}
