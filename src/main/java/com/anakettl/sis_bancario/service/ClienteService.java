package com.anakettl.sis_bancario.service;

import com.anakettl.sis_bancario.models.Cliente;
import com.anakettl.sis_bancario.repositories.ClienteRepository;
import com.anakettl.sis_bancario.service.interfaces.IClienteService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clientes;

    //create
    public void salvar(Cliente cliente) {
        try {
            this.clientes.saveAndFlush(cliente);
        } catch (Exception exception) {
            throw new ServiceException("Não foi possível salvar novo cliente", exception);
        }
    }
    //all
    public List<Cliente> todos() {
        try {
            return clientes.findAll();
        } catch (Exception exception) {
            throw new ServiceException("Não foi possivel listar os clientes", exception);
        }
    }
}
