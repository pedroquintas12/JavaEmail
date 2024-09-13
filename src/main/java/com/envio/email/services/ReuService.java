package com.envio.email.services;

import com.envio.email.models.Processo;
import com.envio.email.models.Processo_autor;
import com.envio.email.models.Processo_reu;
import com.envio.email.repositories.AutorRepository;
import com.envio.email.repositories.ReuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReuService {

    @Autowired
    private ReuRepository reuRepository;

    @Autowired
    AutorReuService autorReuService;

    public List<Processo_reu> BuscarporId (Processo processo)  {
        return reuRepository.findByID(processo);

    }


}
