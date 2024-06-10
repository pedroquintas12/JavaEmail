package com.envio.email.repositories;

import com.envio.email.models.Processo_docinicial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocInicialRepository extends JpaRepository<Processo_docinicial, Integer> {
}
