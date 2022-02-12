package br.com.letscode.cadastrorebeldes;

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
