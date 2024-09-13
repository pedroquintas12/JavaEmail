package com.envio.email.services;

import com.envio.email.models.Cliente;
import com.envio.email.models.Processo;
import com.envio.email.models.Processo_autor;
import com.envio.email.repositories.AutorRepository;
import com.envio.email.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    AutorReuService autorReuService;

    public List<Processo_autor> BuscarporId (Processo processo)  {
        return autorRepository.findByID(processo);

    }

}
