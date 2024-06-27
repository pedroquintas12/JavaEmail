package com.envio.email.services;

import com.envio.email.models.Cliente;
import com.envio.email.models.Processo;
import com.envio.email.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    AutorReuService autorReuService;

    public List<Cliente>BuscarPorEscritorio (Integer codEscritorio)  {
        return clienteRepository.findByCodEscritorio(codEscritorio);

    }

    }
