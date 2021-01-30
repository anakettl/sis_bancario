package com.anakettl.sis_bancario.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Table
@Entity
public class Cliente implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQUENCE_CLIENTES")
    private Long id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cliente")
    private Set<ContaEspecial> contas_especiais;

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

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", cpf " + cpf + "]";
    }
}
