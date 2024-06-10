package com.envio.email.services;

import com.envio.email.models.Processo_reu;
import com.envio.email.repositories.ReuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReuService {

    @Autowired
    ReuRepository reuRepository;

    public List<Processo_reu>  buscartodosReus(){
        return reuRepository.findAll();

    }



}
