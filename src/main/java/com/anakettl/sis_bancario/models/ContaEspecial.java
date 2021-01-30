package com.anakettl.sis_bancario.models;

import javax.persistence.*;

@Entity
@Table
public class ContaEspecial extends Conta {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQUENCE_CONTAS_ESPECIAIS")
    private Long id;

    @Column
    private Double limite;

    public ContaEspecial() {}

    public ContaEspecial(Double saldo, Long numero, Long id, Double limite) {
        super(saldo, numero);
        this.id = id;
        this.limite = limite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "Conta Especial [ "+ super.toString() +" limite=" + limite +  "]";
    }
}
