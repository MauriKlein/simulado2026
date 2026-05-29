package com.simulado.dtos;

import com.simulado.Entity.Jogos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JogosResponseDTO {
    private Long id;
    private String titulo;
    private BigDecimal preco;
    private Integer classificacaoIndicativa;
    private Boolean disponivel;


    public static JogosResponseDTO fromEntity(Jogos entity){
        return JogosResponseDTO.builder()
                .titulo(entity.getTitulo())
                .id(entity.getId())
                .classificacaoIndicativa(entity.getClassificacaoIndicativa())
                .disponivel(entity.getDisponivel())
                .preco(entity.getPreco())
                .build();
    }
}
