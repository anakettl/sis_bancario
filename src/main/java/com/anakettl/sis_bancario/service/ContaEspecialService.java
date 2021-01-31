package com.anakettl.sis_bancario.service;

import com.anakettl.sis_bancario.models.ContaEspecial;
import com.anakettl.sis_bancario.repositories.ContaEspecialRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaEspecialService {

    @Autowired
    private ContaEspecialRepository contas_especiais;

    public ContaEspecialService(ContaEspecialRepository contas_especiais) {
        super();
        this.contas_especiais = contas_especiais;
    }

    //create
    public void salvar(ContaEspecial conta_especial) {

            this.contas_especiais.saveAndFlush(conta_especial);

    }
    //all
    public List<ContaEspecial> todos() {
        try {
            return contas_especiais.findAll();
        } catch (Exception exception) {
            throw new ServiceException("Não foi possivel listar as contas especiais", exception);
        }
    }
}
