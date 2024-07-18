package com.envio.email.repositories;

import com.envio.email.models.Processo;
import com.envio.email.models.Processo_docinicial;
import com.envio.email.models.Processo_reu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocInicialRepository extends JpaRepository<Processo_docinicial, Long> {

    List<Processo_docinicial> findByIDAndDocPeticaoInicial(Processo processo, Boolean docPeticaoInicial);
}
