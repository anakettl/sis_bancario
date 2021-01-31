package com.anakettl.sis_bancario.dto;

import com.anakettl.sis_bancario.models.Agencia;
import com.anakettl.sis_bancario.models.Cliente;
import com.anakettl.sis_bancario.models.ContaEspecial;

public class ContaEspecialDto {
    private Double limite;
    private Long id_cliente;
    private Long id_agencia;

    public ContaEspecialDto() {
    }

    public ContaEspecialDto(Double limite, Long id_cliente, Long id_agencia) {
        this.limite = limite;
        this.id_cliente = id_cliente;
        this.id_agencia = id_agencia;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Long getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(Long id_agencia) {
        this.id_agencia = id_agencia;
    }

    public ContaEspecial toEntity() {
        return new ContaEspecial(
                Double.valueOf("0"),
                100L+this.id_cliente,
                this.limite,
                new Cliente(this.id_cliente),
                new Agencia(this.id_agencia)
        );
    }

}
