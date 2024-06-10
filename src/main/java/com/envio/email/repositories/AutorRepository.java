package com.envio.email.repositories;

import com.envio.email.models.Processo;
import com.envio.email.models.Processo_autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Processo_autor, Integer> {
    // Método para encontrar autores por ID de processo
    List<Processo_autor> findByID(Processo processo);
}
