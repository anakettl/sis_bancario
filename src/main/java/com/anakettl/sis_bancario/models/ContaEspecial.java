package com.anakettl.sis_bancario.models;

import javax.persistence.*;

@Entity
@Table(name="CONTAS_ESPECIAIS")
public class ContaEspecial extends Conta {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQUENCE_CONTAS_ESPECIAIS")
    private Long id;

    @Column
    private Double limite;

    @ManyToOne
    @JoinColumn(name="fk_cliente", nullable=false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="fk_agencia", nullable=false)
    private Agencia agencia;

    public ContaEspecial() {
    }

    public ContaEspecial(Double saldo, Long numero) {
        super(saldo, numero);
    }

    public ContaEspecial(Long id, Double limite, Cliente cliente, Agencia agencia) {
        this.id = id;
        this.limite = limite;
        this.cliente = cliente;
        this.agencia = agencia;
    }

    public ContaEspecial(Double saldo, Long numero, Long id, Double limite, Cliente cliente, Agencia agencia) {
        super(saldo, numero);
        this.id = id;
        this.limite = limite;
        this.cliente = cliente;
        this.agencia = agencia;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "ContaEspecial{" +
                "id=" + id +
                ", limite=" + limite +
                ", cliente=" + cliente +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", numero=" + numero +
                '}';
    }
}
