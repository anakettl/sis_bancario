package com.anakettl.sis_bancario.models;

public enum MenuEnum {
    OP1 ("1 –Cadastrar Conta Especial", "/contas-especiais/create"),
    OP2 ("2 –Pesquisar Conta Especial usando número", "@{/agencias/create}"),
    OP3 ("3 –Pesquisar Conta Especial usando número da agência", "@{/agencias/create}"),
    OP4 ("4 –Pesquisar Conta Especial usando o CPF do cliente", "@{/agencias/create}"),
    OP5 ("5 –Sair", "@{/agencias/create}");

    private final String nome;
    private final String link;

    MenuEnum(String nome, String link) {
        this.nome = nome;
        this.link = link;
    }

    public String getNome() {
        return nome;
    }

    public String getLink() {
        return link;
    }

}
