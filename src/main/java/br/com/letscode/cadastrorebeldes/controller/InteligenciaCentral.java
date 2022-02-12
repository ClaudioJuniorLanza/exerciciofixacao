package br.com.letscode.cadastrorebeldes;

import lombok.Cleanup;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;

public class InteligenciaCentral {

    boolean verificaAceitacaoIC(String racaRebelde){
        Random r = new Random();
        TipoRebelde[] values = TipoRebelde.values();
        boolean existeRebelde = Arrays.asList(values).stream().
                anyMatch(tipoRebelde1 -> tipoRebelde1.getDescricao().equals(racaRebelde));
        if (!existeRebelde){
            System.out.println("Tipo de rebelde não existente. Por favor, tente novamente conforme opções apresentadas.");
            return false;
        }

        String racaAceitavel = Arrays.asList(values).get(r.nextInt(values.length)).getDescricao();
        System.out.println(racaAceitavel);
        return racaAceitavel.equals(racaRebelde);
    }

    public void imprimirRebeldesAdmitidos(RebeldesController cadastroRebelde) throws FileNotFoundException, UnsupportedEncodingException {
        @Cleanup PrintWriter writer = new PrintWriter("lista-admitidos.txt", "UTF-8");
        writer.println("LISTA DOS REBELDES ADMITIDOS");
        writer.println("Nome: " + cadastroRebelde.getNome() + " - "
                     + "Idade: " + cadastroRebelde.getIdade() + " - "
                     + "Raça: " + cadastroRebelde.getTipoRebelde().getDescricao());
        writer.println("--------------------------------------------------------------------");
        System.out.println("Rebelde adicionado a lista com sucesso!");
    }
}
