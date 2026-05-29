package com.simulado.dto;

import com.simulado.entity.Jogos;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JogoRequestDTO {

    @Size(min = 3, max = 100)
    private String titulo;
    @Positive
    private BigDecimal preco;
    @Positive
    private Integer estoque;
    @Positive
    private Integer classificacaoIndicativa;
    private boolean disponivel;
    private String codigoInterno = UUID.randomUUID().toString();

    public static Jogos dtoToEntity(JogoRequestDTO entity) {
        return Jogos.builder()
                .titulo(entity.getTitulo())
                .preco(entity.getPreco())
                .disponivel(entity.getEstoque() > 0)
                .estoque(entity.getEstoque())
                .classificacaoIndicativa(entity.getClassificacaoIndicativa())
                .build();
    }

}
