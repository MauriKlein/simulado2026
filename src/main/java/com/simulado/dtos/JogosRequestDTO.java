package com.simulado.dtos;

import com.simulado.Entity.Jogos;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JogosRequestDTO {
    @Size (min = 3, message = "O título deve ter pelo menos 3 dígitos")
    private String titulo;

    @DecimalMin(value = "0.0", message = "O preço deve ser igual ou maior a zero")
    private BigDecimal preco;

    @Min(value = 0, message = "O número no estoque deve ser maior ou igual a zero")
    private Integer estoque;

    @Min(value = 0, message = "A classificação indicativa mínima é 0")
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
