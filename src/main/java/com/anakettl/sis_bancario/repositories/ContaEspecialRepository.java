package com.anakettl.sis_bancario.repositories;

import com.anakettl.sis_bancario.models.ContaEspecial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaEspecialRepository extends JpaRepository<ContaEspecial,Integer> {
    Optional<ContaEspecial> findById(Integer id);
    List<ContaEspecial> findByNumero(Long numero);
    List<ContaEspecial> findByAgencia(String numero);
    List<ContaEspecial> findByCliente(String cpf);
}
