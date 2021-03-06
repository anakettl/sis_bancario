package com.anakettl.sis_bancario.repositories;

import com.anakettl.sis_bancario.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    List<Cliente> findAll();
    Optional<Cliente> findById(Integer id);
}
