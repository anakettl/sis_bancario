package com.anakettl.sis_bancario.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="CLIENTES")
public class Cliente implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQUENCE_CLIENTES")
    private Long id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<ContaEspecial> contas_especiais;

    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, List<ContaEspecial> contas_especiais) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.contas_especiais = contas_especiais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ContaEspecial> getContas_especiais() {
        return contas_especiais;
    }

    public void setContas_especiais(List<ContaEspecial> contas_especiais) {
        this.contas_especiais = contas_especiais;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", contas_especiais=" + contas_especiais +
                '}';
    }
}
