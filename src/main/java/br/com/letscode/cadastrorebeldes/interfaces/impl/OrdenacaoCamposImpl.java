package br.com.letscode.cadastrorebeldes.interfaces.impl;

import br.com.letscode.cadastrorebeldes.domain.Rebelde;
import br.com.letscode.cadastrorebeldes.enums.OpcaoFiltro;
import br.com.letscode.cadastrorebeldes.interfaces.ComparacaoCamposInterface;
import br.com.letscode.cadastrorebeldes.interfaces.OrdenacaoCamposInterface;

import java.util.ArrayList;
import java.util.List;

public class OrdenacaoCamposImpl implements OrdenacaoCamposInterface {

    @Override
    public ArrayList<Rebelde> ordenacao(List<Rebelde> rebeldeList, ComparacaoCamposInterface comparacaoCamposInterface) {

        for (int i = 0; i < rebeldeList.size(); i++){
            int menorIndice = i;
            for (int x = i + 1; x < rebeldeList.size(); x++){
                int proximoIndice = x;
                if (comparacaoCamposInterface.obtemMenor(rebeldeList.get(proximoIndice), rebeldeList.get(menorIndice))){
                    menorIndice = x;
                }
            }
            Rebelde rebeldeAuxiliar = rebeldeList.get(i);
            rebeldeList.set(i, rebeldeList.get(menorIndice));
            rebeldeList.set(menorIndice, rebeldeAuxiliar);
        }
        return (ArrayList<Rebelde>) rebeldeList;
    }
}
