package com.envio.email.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.envio.email.dtos.ProcessoDTO;
import com.envio.email.models.Processo;
import com.envio.email.models.Processo_autor;
import com.envio.email.models.Processo_reu;
import com.envio.email.repositories.AutorRepository;
import com.envio.email.repositories.ProcessoRepository;
import com.envio.email.repositories.ReuRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorReuService {

    private final ProcessoRepository processoRepository;
    private final AutorRepository autorRepository;
    private final ReuRepository reuRepository;

    public AutorReuService(ProcessoRepository processoRepository, AutorRepository autorRepository,
                           ReuRepository reuRepository) {
        this.processoRepository = processoRepository;
        this.autorRepository = autorRepository;
        this.reuRepository = reuRepository;
    }

    public List<ProcessoDTO> buscarAutoresReusPorParametros(String status, Integer codEscritorio) {
        // Gerar um localizador aleatório
        String localizador = UUID.randomUUID().toString();

        // Buscar processos com base nos parâmetros fornecidos
        List<Processo> processos = processoRepository.findByStatusAndCodEscritorio(status, codEscritorio);

        // Inicializar lista para armazenar DTOs de processo
        List<ProcessoDTO> autorReuDTOList = new ArrayList<>();

        // Iterar sobre os processos encontrados
        for (Processo processo : processos) {
            // Verificar se o processo pertence ao mesmo escritório
            if (processo.getCodEscritorio().equals(codEscritorio)) {
                // Buscar autores e réus correspondentes para o processo atual
                List<Processo_autor> autores = autorRepository.findByID(processo);
                List<Processo_reu> reus = reuRepository.findByID(processo);

                // Criar DTO de processo com autores e réus encontrados e adicionar à lista
                ProcessoDTO dto = new ProcessoDTO();
                dto.setID_Processo(processo.getID_processo());
                dto.setAutores(autores);
                dto.setReus(reus);
                dto.setLocalizador(localizador); // Definir o localizador no DTO
                autorReuDTOList.add(dto);
            }
        }

        return autorReuDTOList;
    }
}
