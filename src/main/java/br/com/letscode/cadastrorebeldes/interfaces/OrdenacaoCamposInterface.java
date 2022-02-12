package br.com.letscode.cadastrorebeldes.interfaces;

import br.com.letscode.cadastrorebeldes.domain.Rebelde;
import br.com.letscode.cadastrorebeldes.enums.OpcaoFiltro;

import java.util.ArrayList;
import java.util.List;

public interface OrdenacaoCamposInterface {

    ArrayList<Rebelde> ordenacao(List<Rebelde> rebeldeList, ComparacaoCamposInterface comparacaoCamposInterface);
}
