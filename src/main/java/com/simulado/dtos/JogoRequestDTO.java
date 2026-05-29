package com.simulado.dtos;

import com.simulado.entity.Jogo;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

    @Size(min = 3, message = "O título deve conter no mímino 3 caracteres.")
    private String titulo;

    @DecimalMin(value = "0.0", message = "O valor deve ser maior ou igual a 0")
    private BigDecimal preco;

    @Min(value = 0, message = "O valor deve ser maior ou igual a 0")
    private Integer estoque;

    @Min(value = 0, message = "O valor deve ser maior ou igual a 0")
    private Integer classificacaoIndicativa;

    public static Jogo dtoToEntity(JogoRequestDTO jogoRequestDTO) {
        return Jogo.builder()
                .titulo(jogoRequestDTO.getTitulo())
                .preco(jogoRequestDTO.getPreco())
                .estoque(jogoRequestDTO.getEstoque())
                .classificacaoIndicativa(jogoRequestDTO.getClassificacaoIndicativa())
                .codigoInterno(UUID.randomUUID().toString())
                .disponivel(jogoRequestDTO.getEstoque() > 0 ? true : false) //if else(boolean)
                .build();

    }
}