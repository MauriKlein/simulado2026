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
public class JogoResponseDTO {

    private Long id;
    private String titulo;
    private BigDecimal preco;
    private Integer classificacaoIndicativa;
    private Boolean disponivel;


    public static JogoResponseDTO entityToDto(Jogo jogo){
        return JogoResponseDTO.builder()
                .id(jogo.getId())
                .titulo(jogo.getTitulo())
                .preco(jogo.getPreco())
                .classificacaoIndicativa(jogo.getClassificacaoIndicativa())
                .disponivel(jogo.getDisponivel())
                .build();
    }
}
