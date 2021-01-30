package com.anakettl.sis_bancario.repositories;

import com.anakettl.sis_bancario.models.ContaEspecial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaEspecialRepository extends JpaRepository<ContaEspecial,Integer> {
    Optional<ContaEspecial> findById(Integer id);
}
