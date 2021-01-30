package com.anakettl.sis_bancario.service;

import com.anakettl.sis_bancario.models.Agencia;
import com.anakettl.sis_bancario.repositories.AgenciaRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
