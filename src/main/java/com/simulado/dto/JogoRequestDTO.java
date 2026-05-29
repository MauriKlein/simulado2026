package com.simulado.dto;

import com.simulado.entity.Jogo;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JogoRequestDTO {

    @NotNull(message = "O título é obrigatório")
    @Size(min = 3, message = "O título deve conter pelo menos 3 caracteres")
    private String titulo;

    @DecimalMin(value = "0.0", message = "O preço deve ser maior que zero")
    private BigDecimal preco;

    @Positive(message = "O estoque deve ser um número positivo")
    private Integer estoque;

    @Min(value = 0, message = "A classificação indicativa deve ser maior ou igual a zero")
    private Integer classificacaoIndicativa;

    public static Jogo dtoToEntity(JogoRequestDTO jogoRequestDTO){
        return Jogo.builder()
                .titulo(jogoRequestDTO.getTitulo())
                .preco(jogoRequestDTO.getPreco())
                .estoque(jogoRequestDTO.getEstoque())
                .classificacaoIndicativa(jogoRequestDTO.getClassificacaoIndicativa())
                .codigoInterno(UUID.randomUUID().toString())
                .disponivel(jogoRequestDTO.getEstoque() > 0)
                .build();

    }

}
