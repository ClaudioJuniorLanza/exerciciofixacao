package br.com.letscode.cadastrorebeldes.interfaces.impl;

import br.com.letscode.cadastrorebeldes.domain.Rebelde;
import br.com.letscode.cadastrorebeldes.interfaces.ComparacaoCamposInterface;

public class ComparacaoPorNomeImpl implements ComparacaoCamposInterface {
    @Override
    public boolean obtemMenor(Rebelde xRebelde, Rebelde yRebelde) {
        return xRebelde.getNome().compareToIgnoreCase(yRebelde.getNome()) < 0;
    }
}
