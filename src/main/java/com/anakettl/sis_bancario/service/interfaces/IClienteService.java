package com.anakettl.sis_bancario.service.interfaces;

public interface IClienteService {
    public default boolean validarCpf(String cpf){
        if(cpf.length() == 11) return true;
        return false;
    }
}
