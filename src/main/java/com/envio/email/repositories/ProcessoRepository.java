package com.envio.email.repositories;

import com.envio.email.models.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessoRepository extends BaseRepository<Processo, Integer> {

    List<Processo> findByStatusAndCodEscritorio(String status, Integer codEscritorio);

    List<Processo> findAll();


}
