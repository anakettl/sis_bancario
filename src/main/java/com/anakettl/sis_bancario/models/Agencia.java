package com.anakettl.sis_bancario.models;

import javax.persistence.*;

@Table
@Entity


public class Agencia {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQUENCE_AGENCIAS")
    private Long id;

    @Column
    private String numero;

    @Column
    private String endereco;

    public Agencia() {}

    public Agencia(Long id, String numero, String endereco) {
        this.numero = numero;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
