package com.anakettl.sis_bancario.repositories;

import com.anakettl.sis_bancario.models.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
    Optional<Agencia> findById(Long id);
}
