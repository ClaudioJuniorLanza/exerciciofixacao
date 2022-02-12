package br.com.letscode.cadastrorebeldes.domain;

import br.com.letscode.cadastrorebeldes.enums.TipoRebelde;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rebelde {

    @NotNull(message = "O nome não pode ser nulo ou vazio")
    private String nome;
    @NotNull(message = "A idade não pode ser nulo ou vazio")
    private Integer idade;
    private TipoRebelde tipoRebelde;

    @Override
    public String toString(){
        return "Rebelde(nome=" + getNome() + ", idade=" + getIdade() + ", raca=" + tipoRebelde.getDescricao() + ")";
    }
}
