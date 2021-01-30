package com.anakettl.sis_bancario.models;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class Conta implements Serializable {
    @Column
    protected Double saldo;

    @Column
    protected Long numero;

    public Conta() {}

    public Conta(Double saldo, Long numero) {
        this.saldo = saldo;
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Conta [numero=" + numero + ", saldo " + saldo + "]";
    }

}
