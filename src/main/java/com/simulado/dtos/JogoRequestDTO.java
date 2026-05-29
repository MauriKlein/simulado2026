package com.simulado.dtos;

import com.simulado.entity.Jogo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JogoRequestDTO {

    @NotBlank(message = "Obrigatório, mínimo 3 caracteres")
    private String titulo;

    @Size(message = "Deve ser maior ou igual a 0")
    private BigDecimal preco;

    @Positive(message = "Deve ser maior ou igual a 0")
    private Integer estoque;

    @Positive(message = "Deve ser maior ou igual a 0")
    private Integer classificacaoIndicativa;


    public static Jogo dtoToEntity(JogoRequestDTO jogoRequestDTO) {
        return Jogo.builder()
                .titulo(jogoRequestDTO.getTitulo())
                .preco(jogoRequestDTO.getPreco())
                .estoque(jogoRequestDTO.getEstoque())
                .classificacaoIndicativa(jogoRequestDTO.getClassificacaoIndicativa())
                .codigoInterno(java.util.UUID.randomUUID().toString())
                .disponivel(jogoRequestDTO.getEstoque() > 0 ? true : false)
                .build();
    }
}