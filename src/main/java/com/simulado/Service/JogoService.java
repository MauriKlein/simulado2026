package com.simulado.Service;

import com.simulado.dtos.JogoRequestDto;
import com.simulado.dtos.JogoResponseDto;
import com.simulado.entity.Jogo;
import com.simulado.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service

public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public JogoResponseDto save(JogoRequestDto dto) {
        Jogo jogo = jogoRepository.save(JogoRequestDto.dtoToEntity(dto));
        return JogoResponseDto.entityToDto(jogo);
    }

    public JogoResponseDto findById(Long id){
        return JogoResponseDto.entityToDto((jogoRepository.findById(id).get()));
    }

    public JogoResponseDto updateEvento(Long id, JogoRequestDto jogoRequestDto) {
        Optional<Jogo> jogoSalvo = jogoRepository.findById(id);
        if (jogoSalvo.isPresent()) {
            Jogo jogo = jogoSalvo.get();
            jogo.setTitulo(jogoRequestDto.getTitulo());
            jogo.setPreco(jogo.getPreco());
            jogo.setClassificacaoIndicativa(jogo.getClassificacaoIndicativa());
            jogo.setEstoque(jogoRequestDto.getEstoque());

        }
        throw new RuntimeException("Evento não encontrado...");
}

    public String deletarJogo(Long id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        if (jogo.isPresent()) {
            jogoRepository.deleteById(jogo.get().getId());
            return "Jogo deletado com sucesso!";
        } else {
            return "Jogo não encontrado com esse ID: " + id;
        }
    }

    
}