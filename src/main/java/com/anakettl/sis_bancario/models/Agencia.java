package com.anakettl.sis_bancario.models;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL)
    private List<ContaEspecial> contas_especiais;

    public Agencia() {}

    public Agencia(Long id) {
        this.id = id;
    }


    public Agencia(Long id, String numero, String endereco, List<ContaEspecial> contas_especiais) {
        this.id = id;
        this.numero = numero;
        this.endereco = endereco;
        this.contas_especiais = contas_especiais;
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

    public List<ContaEspecial> getContas_especiais() {
        return contas_especiais;
    }

    public void setContas_especiais(List<ContaEspecial> contas_especiais) {
        this.contas_especiais = contas_especiais;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", endereco='" + endereco + '\'' +
                ", contas_especiais=" + contas_especiais +
                '}';
    }
}
