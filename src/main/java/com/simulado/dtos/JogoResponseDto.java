package com.simulado.dtos;

import com.simulado.entity.Jogo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JogoResponseDto {
    private Long id;
    private String titulo;
    private BigDecimal preco;
    private Integer classificacaoIndicativa;
    private Boolean disponivel;

    public static JogoResponseDto entityToDto(Jogo jogo){
        return JogoResponseDto.builder()
                .titulo(jogo.getTitulo())
                .preco(jogo.getPreco())
                .classificacaoIndicativa(jogo.getClassificacaoIndicativa())
                .disponivel(jogo.getDisponivel())
                .build();
    }

}
