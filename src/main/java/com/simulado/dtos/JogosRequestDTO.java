package com.simulado.dtos;

import com.simulado.Entity.Jogos;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class JogosRequestDTO {

    @NotNull(message = "O titulo é obrigatório")
    @Size(min = 3, message = "O titulo deve ter pelo menos 3 caracteres")
    private String titulo;

    @NotNull(message = "O preco é obrigatório")
    @DecimalMin(value = "0.0", message = "O preco deve ser maior ou igual a zero")
    private BigDecimal preco;

    @NotNull(message = "O estoque é obrigatório")
    @Min(value = 0, message = "O estoque deve ser maior ou igual a zero")
    private Integer estoque;

    @NotNull(message = "A classificacao indicativa é obrigatória")
    @Min(value = 0, message = "A classificacao indicativa deve ser maior ou igual a zero")
    private Integer classificacaoIndicativa;

    public static Jogos dtoToEntity(JogosRequestDTO jogosRequestDTO) {
        return Jogos.builder()
                .titulo(jogosRequestDTO.titulo)
                .preco(jogosRequestDTO.preco)
                .estoque(jogosRequestDTO.estoque)
                .classificacaoIndicativa(jogosRequestDTO.classificacaoIndicativa)
                .codigoInterno(java.util.UUID.randomUUID().toString())
                // pra ter o codigo interno aleatorio
                .disponivel(jogosRequestDTO.getEstoque() > 0 ? true : false)
                // "if" jogosRequestDTO.getEstoque() > 0 = true, : ": = Se não" false
                .build();
    }
}


