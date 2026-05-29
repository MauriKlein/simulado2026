package com.simulado.dto;

import com.simulado.entity.Jogos;
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
public class JogosResponseDTO {
    private String titulo;
    private BigDecimal preco;
    private Integer classificacaoIndicada;
    private Boolean disponivel;

    public static JogosResponseDTO fromEntity(Jogos entity) {
        return JogosResponseDTO.builder()
                .titulo(entity.getTitulo())
                .preco(entity.getPreco())
                .classificacaoIndicada(entity.getClassificacaoIndicada())
                .disponivel(entity.getDisponivel())
                .build();
    }
}
