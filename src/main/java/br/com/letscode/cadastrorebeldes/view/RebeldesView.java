package br.com.letscode.cadastrorebeldes.controller;

import br.com.letscode.cadastrorebeldes.domain.Rebelde;
import br.com.letscode.cadastrorebeldes.enums.TipoRebelde;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Data
@Builder
public class RebeldesController {

    public void cadastroRebelde() {
        InteligenciaCentral ic = new InteligenciaCentral();
        List<Rebelde> rebeldeList = new ArrayList<>();

        String respostaContinue = null;
        String msgParaContinuar = "Deseja adicionar um novo cadastro?";

        System.out.println("Bem vindo ao cadastro dos rebeldes!");

        while(true){
            System.out.println("Informe a sua Raça (humano, gree ou rakata) e verificaremos se pode fazer parte da causa:");
            String racaRebelde = new Scanner(System.in).next();
            if(ic.verificaAceitacaoIC(racaRebelde.toLowerCase())){
                rebeldeList.add(cadastro(racaRebelde));
                respostaContinue = continuar(msgParaContinuar);
            }else{
                System.out.println("Desculpe, você não foi aceito pra fazer parte da causa");
                msgParaContinuar = "Deseja tentar novamente o cadastro?";
                respostaContinue = continuar(msgParaContinuar);
            }
            switch (respostaContinue){
                case "NAO":
                    ic.imprimirRebeldesAdmitidos(rebeldeList);
                    break;
                default:
                    continue;
            }
        }
    }

    public Rebelde cadastro(String racaRebelde){
        Rebelde rebelde = new Rebelde();
        rebelde.setTipoRebelde(TipoRebelde.valueOf(racaRebelde.toUpperCase()));
        System.out.println("Você é um rebelde aceito! Continue seu cadastro");
        System.out.println("Qual é o seu nome?");
        rebelde.setNome(new Scanner(System.in).next());
        System.out.println("Qual é a sua idade?");
        rebelde.setIdade(new Scanner(System.in).nextInt());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Rebelde>> constraintViolationSet = validator.validate(rebelde);

        if(!constraintViolationSet.isEmpty()){
            constraintViolationSet.forEach(rebeldeConstraintViolation ->
                    System.out.println(rebeldeConstraintViolation.getPropertyPath() + " - " + rebeldeConstraintViolation.getMessage()));
            System.out.println("Por favor, realize seu cadastro novamente");
            cadastro(racaRebelde);
        }

        System.out.println("cadastro limpo!");
        return rebelde;
    }

    public String continuar(String msgParaContinuar){
        System.out.println(msgParaContinuar);
        System.out.println("SIM");
        System.out.println("NAO");

        while(true){
            System.out.println("Digite sua opção:");
            String continuaCadastro = new Scanner(System.in).next();
            if ("SIM".equals(continuaCadastro) || "NAO".equals(continuaCadastro)){
                return continuaCadastro;
            }
            System.out.println("Opção inválida. Digite novamenete");
        }
    }

}
