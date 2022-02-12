package br.com.letscode.cadastrorebeldes.controller;

import br.com.letscode.cadastrorebeldes.domain.Rebelde;
import br.com.letscode.cadastrorebeldes.enums.TipoRebelde;
import lombok.Cleanup;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InteligenciaCentral {

    public boolean verificaAceitacaoIC(String racaRebelde){
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

    public void imprimirRebeldesAdmitidos(List<Rebelde> rebeldesList){
        rebeldesList.stream().forEach(rebelde -> System.out.println(rebelde.toString()));
        escreverDadosArquivo(rebeldesList);

    }

    public void escreverDadosArquivo(List<Rebelde> rebeldeList) {

        File file = new File("lista-admitidos.txt");
        if (file.exists()){
            try {
                @Cleanup FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
                @Cleanup PrintWriter printWriter = new PrintWriter(fileWriter);
                rebeldeList.stream().
                        forEach(rebelde -> printWriter.println(rebelde.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                @Cleanup PrintWriter writer = new PrintWriter("lista-admitidos.txt", "UTF-8");
                rebeldeList.stream().
                        forEach(rebelde -> writer.println(rebelde.toString()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
