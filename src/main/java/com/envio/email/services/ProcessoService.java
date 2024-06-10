package com.envio.email.services;

import com.envio.email.models.Processo;
import com.envio.email.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessoService {
        @Autowired
        private ProcessoRepository processoRepository;

            public List<Processo> buscarTodosProcessos() {
                return processoRepository.findByStatusAndCodEscritorio("P",1172);
        }




}
