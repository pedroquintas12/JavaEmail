    package com.envio.email.services;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.UUID;

    import com.envio.email.dtos.ProcessoDTO;
    import com.envio.email.models.*;
    import com.envio.email.repositories.*;
    import org.springframework.stereotype.Service;

    @Service
    public class AutorReuService {

        private final ProcessoRepository processoRepository;
        private final AutorRepository autorRepository;
        private final ReuRepository reuRepository;
        private final DocInicialRepository docInicialRepository;

        public AutorReuService(ProcessoRepository processoRepository, AutorRepository autorRepository,
                               ReuRepository reuRepository, DocInicialRepository docInicialRepository) {
            this.processoRepository = processoRepository;
            this.autorRepository = autorRepository;
            this.reuRepository = reuRepository;
            this.docInicialRepository = docInicialRepository;
        }

        public List<ProcessoDTO> buscarAutoresReusPorParametros(String status, Integer codEscritorio) {
            List<Processo> processos = processoRepository.findByStatusAndCodEscritorio(status, codEscritorio);

            List<ProcessoDTO> autorReuDTOList = new ArrayList<>();



            for (Processo processo : processos) {
                if (processo.getCodEscritorio().equals(codEscritorio)) {
                    List<Processo_autor> autores = autorRepository.findByID(processo);
                    List<Processo_reu> reus = reuRepository.findByID(processo);
                    List<Processo_docinicial> link = docInicialRepository.findByProcessoIdAndDocPeticaoInicialIsZero(processo.getID_processo());


                    ProcessoDTO dto = new ProcessoDTO();
                    dto.setID_Processo(processo.getID_processo());
                    dto.setAutores(autores);
                    dto.setReus(reus);
                    dto.setCidade(processo.getCidade());
                    dto.setOrgaoJulgador(processo.getOrgaoJulgador());
                    dto.setComarca(processo.getComarca());
                    dto.setDataDistribuicao(processo.getDataDistribuicao());
                    dto.setInstancia(processo.getInstancia());
                    dto.setNumeroProcesso(processo.getNumeroProcesso());
                    dto.setSiglaSistema(processo.getSiglaSistema());
                    dto.setUf(processo.getUf());
                    dto.setCodEscritorio(processo.getCodEscritorio());
                    dto.setTribunal(processo.getTribunal());
                    dto.setLink(link);
                    dto.setTipoProcesso(processo.getTipoProcesso());
                    autorReuDTOList.add(dto);
                }
            }

            return autorReuDTOList;
        }
    }
