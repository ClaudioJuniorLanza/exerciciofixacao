package br.com.letscode.cadastrorebeldes.controller;

import br.com.letscode.cadastrorebeldes.domain.Rebelde;
import br.com.letscode.cadastrorebeldes.enums.OpcaoFiltro;
import br.com.letscode.cadastrorebeldes.factory.ComparacaoCamposFactory;
import br.com.letscode.cadastrorebeldes.interfaces.impl.OrdenacaoCamposImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrdenacaoController {

    public String tipoDeOrdenacao(){
        System.out.println("Voce deseja ordenar por qual campo?");
        OpcaoFiltro[] opcaoFiltros = OpcaoFiltro.values();
        Arrays.asList(opcaoFiltros).stream().forEach(opcaoFiltro -> System.out.println(opcaoFiltro.getDescricao()));

        while(true){
            System.out.println("Digite sua opção:");
            String opcaoParaOrdenacao = new Scanner(System.in).next();
            boolean existeOpcao = Arrays.asList(opcaoFiltros).stream().
                    anyMatch(opcaoFiltro -> opcaoFiltro.getDescricao().equals(opcaoParaOrdenacao));
            if (existeOpcao){
                return opcaoParaOrdenacao;
            }
            System.out.println("Opção inválida! Tente novamente");
        }
    }

    public List<Rebelde> executarOrdenacao(List<Rebelde> rebeldeList, String opcaoParaOrdenacao){
        ComparacaoCamposFactory comparacaoCamposFactory = new ComparacaoCamposFactory();
        OrdenacaoCamposImpl ordenacaoCampos = new OrdenacaoCamposImpl();

        return ordenacaoCampos.
                ordenacao(rebeldeList, comparacaoCamposFactory.fabricate(OpcaoFiltro.valueOf(opcaoParaOrdenacao.toUpperCase())));
    }
}
