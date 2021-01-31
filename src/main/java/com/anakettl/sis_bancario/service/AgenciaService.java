package com.anakettl.sis_bancario.service;

import com.anakettl.sis_bancario.models.Agencia;
import com.anakettl.sis_bancario.repositories.AgenciaRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agencias;

    //create
    public void salvar(Agencia agencia) {
        try {
            this.agencias.saveAndFlush(agencia);
        } catch (Exception exception) {
            throw new ServiceException("Não foi possível salvar nova agencia", exception);
        }
    }
    //all
    public List<Agencia> todos() {
        try {
            return agencias.findAll();
        } catch (Exception exception) {
            throw new ServiceException("Não foi possivel listar as agencias", exception);
        }
    }

    //READ
    public Agencia agencia(Long id) {
        try {
            Optional<Agencia> agencia = this.agencias.findById(id);
            if (agencia.isPresent()) return agencia.get();
            else throw new ServiceException("Nao foi possivel buscar a agencia");
        } catch (Exception exception) {
            throw new ServiceException("Erro, ", exception);
        }
    }
}
