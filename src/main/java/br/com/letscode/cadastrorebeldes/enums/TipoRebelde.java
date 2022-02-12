package br.com.letscode.cadastrorebeldes.enums;

public enum TipoRebelde {

    HUMANO("humano"),
    GREE("gree"),
    RAKATA("rakata");

    private String descricao;

    TipoRebelde(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }


}
