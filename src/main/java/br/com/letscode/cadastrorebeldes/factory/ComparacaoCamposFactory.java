package br.com.letscode.cadastrorebeldes.factory;

import br.com.letscode.cadastrorebeldes.enums.OpcaoFiltro;
import br.com.letscode.cadastrorebeldes.interfaces.ComparacaoCamposInterface;
import br.com.letscode.cadastrorebeldes.interfaces.impl.ComparacaoPorIdadeImpl;
import br.com.letscode.cadastrorebeldes.interfaces.impl.ComparacaoPorNomeImpl;
import br.com.letscode.cadastrorebeldes.interfaces.impl.ComparacaoPorRacaImpl;

public class ComparacaoCamposFactory {

    public ComparacaoCamposInterface fabricate(OpcaoFiltro opcaoFiltro){
        switch (opcaoFiltro.getDescricao()){
            case "nome":
                return new ComparacaoPorNomeImpl();
            case "idade":
                return new ComparacaoPorIdadeImpl();
            case "raca":
                return new ComparacaoPorRacaImpl();
            default:
                System.out.println("Opção inválida. Será ordenado por nome");
                return new ComparacaoPorNomeImpl();
        }
    }
}
