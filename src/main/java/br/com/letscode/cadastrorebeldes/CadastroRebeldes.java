package br.com.letscode.cadastrorebeldes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastroRebeldes {

    private String nome;
    private Integer idade;
    private TipoRebelde tipoRebelde;

    public void cadastroRebelde() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("Bem vindo ao cadastro dos rebeldes!");
        System.out.println("Informe a sua Raça (humano, gree ou rakata) e verificaremos se pode fazer parte da causa:");

        String racaRebelde = new Scanner(System.in).next();
        InteligenciaCentral ic = new InteligenciaCentral();

        if(ic.verificaAceitacaoIC(racaRebelde.toLowerCase())){
            this.setTipoRebelde(TipoRebelde.valueOf(racaRebelde.toUpperCase()));
            System.out.println("Você é um rebelde aceito! Continue seu cadastro");
            System.out.println("Qual é o seu nome?");
            this.setNome(new Scanner(System.in).next());
            System.out.println("Qual é a sua idade?");
            this.setIdade(new Scanner(System.in).nextInt());
            ic.imprimirRebeldesAdmitidos(new CadastroRebeldes(this.getNome(), this.getIdade(), this.getTipoRebelde()));
        }else
            System.out.println("Desculpe, você não foi aceito pra fazer parte da causa");
    }
}
