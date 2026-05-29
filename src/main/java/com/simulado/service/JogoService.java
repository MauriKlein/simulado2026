package com.simulado.service;

import com.simulado.dto.JogoRequestDTO;
import com.simulado.dto.JogoResponseDTO;
import com.simulado.entity.Jogo;
import com.simulado.handlers.MinhaException;
import com.simulado.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<JogoResponseDTO> findAll() {
        List<Jogo> jogos = jogoRepository.findAll();
        return jogos.stream()
                .map(JogoResponseDTO::entityToDto)
                .toList();
    }

    public JogoResponseDTO findJogoById(Long id) {
        return jogoRepository.findById(id)
                .map(JogoResponseDTO::entityToDto)
                .orElseThrow(() -> new MinhaException("Jogo não encontrado com id: " + id));
    }

    public JogoResponseDTO save(JogoRequestDTO jogoRequestDTO){
        return JogoResponseDTO.entityToDto(
                jogoRepository.save(JogoRequestDTO.dtoToEntity(jogoRequestDTO))
        );
    }

    public  JogoResponseDTO update(Long id, JogoRequestDTO jogoRequestDTO){
        Optional<Jogo> jogo = jogoRepository.findById(id);
        if(jogo.isPresent()){
            Jogo jogoAtualizado = jogo.get();
            jogoAtualizado.setTitulo(jogoRequestDTO.getTitulo() != null ? jogoRequestDTO.getTitulo() : jogoAtualizado.getTitulo());
            jogoAtualizado.setPreco(jogoRequestDTO.getPreco() != null ? jogoRequestDTO.getPreco() : jogoAtualizado.getPreco());
            jogoAtualizado.setEstoque(jogoRequestDTO.getEstoque() != null ? jogoRequestDTO.getEstoque() : jogoAtualizado.getEstoque());
            jogoAtualizado.setClassificacaoIndicativa(jogoRequestDTO.getClassificacaoIndicativa() != null ? jogoRequestDTO.getClassificacaoIndicativa() : jogoAtualizado.getClassificacaoIndicativa());

            return JogoResponseDTO.entityToDto(jogoRepository.save(jogoAtualizado));
        } else {
            throw new MinhaException("Jogo não encontrado com id: " + id);
        }
    }

    public  void delete(Long id) {
        jogoRepository.deleteById(id);
    }

}
