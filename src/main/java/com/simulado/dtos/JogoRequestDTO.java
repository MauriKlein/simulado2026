package com.simulado.dtos;

import com.simulado.entity.Jogo;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
    @Size(min = 3, message = "Obrigatório, mínimo 3 caracteres")
    private String titulo;

    @DecimalMin(value = "0.0", message = "Deve ser maior ou igual a 0")
    private BigDecimal preco;

    @Positive(message = "O valor deve ser positivo")
    private Integer estoque;

    @Min(value = 0, message = "Deve ser maior ou igual a 0")
    private Integer classificacaoIndicada;


    public static Jogo dtoToEntity(JogoRequestDTO jogoRequestDTO) {
        return Jogo.builder()
                .titulo(jogoRequestDTO.getTitulo())
                .preco(jogoRequestDTO.getPreco())
                .estoque(jogoRequestDTO.getEstoque())
                .classificacaoIndicativa(jogoRequestDTO.getClassificacaoIndicada())
                .codigoInterno(UUID.randomUUID().toString())
                .disponivel(jogoRequestDTO.getEstoque() > 0 ? true : false)
                .build();
    }
}
