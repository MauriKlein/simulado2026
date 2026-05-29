package com.simulado.dto;

import com.simulado.entity.Jogos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JogoResponseDTO {
    private String titulo;
    private BigDecimal preco;
    private Boolean disponivel;
    private Integer classificacaoIndicativa;

    public static JogoResponseDTO fromEntity(Jogos entity) {
        return JogoResponseDTO.builder()
                .titulo(entity.getTitulo())
                .preco(entity.getPreco())
                .disponivel(entity.getDisponivel())
                .classificacaoIndicativa(entity.getClassificacaoIndicativa())
                .build();
    }
}
