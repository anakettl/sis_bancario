package com.anakettl.sis_bancario.models;

import javax.persistence.*;

@MappedSuperclass
public abstract class Conta {

    protected Double saldo;

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

    public boolean credita(double valor) {
        boolean resultado;
        if (valor > 0) {
            this.saldo = this.saldo + valor;
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }

    public boolean debita(double valor) {
        boolean resultado;
        if (saldo > valor) {
            this.saldo = this.saldo + valor;
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                ", numero=" + numero +
                '}';
    }
}
