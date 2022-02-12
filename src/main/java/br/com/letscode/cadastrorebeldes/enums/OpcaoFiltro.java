package br.com.letscode.cadastrorebeldes.enums;

public enum OpcaoFiltro {

    NOME("nome"),
    IDADE("idade"),
    RACA("raca");

    private String descricao;

    OpcaoFiltro(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}
