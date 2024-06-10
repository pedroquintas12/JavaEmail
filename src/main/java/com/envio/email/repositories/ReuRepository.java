package com.envio.email.repositories;

import com.envio.email.models.Processo;
import com.envio.email.models.Processo_reu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReuRepository extends JpaRepository<Processo_reu, Integer> {
        // Método para encontrar réus por ID de processo
        List<Processo_reu> findByID(Processo processo);
}
