package com.simulado.service;

import com.simulado.dtos.JogoRequestDTO;
import com.simulado.dtos.JogoResponseDTO;
import com.simulado.entity.Jogo;
import com.simulado.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public JogoResponseDTO save(JogoRequestDTO jogoRequestDTO) {
        Jogo jogo = jogoRepository.save(JogoRequestDTO.dtoToEntity(jogoRequestDTO));
        return JogoResponseDTO.entityToDto((jogo));

    }

    public JogoResponseDTO findById(Long id) {
        return JogoResponseDTO.entityToDto(jogoRepository.findById(id).get());
    }

    public List<JogoResponseDTO> findAll() {
        return jogoRepository.findAll().stream().map(JogoResponseDTO::entityToDto).toList();

    }

    public JogoResponseDTO updateEventos(Long id, JogoRequestDTO jogoRequestDTO) {
        Optional<Jogo> jogoSalvo = jogoRepository.findById(id);
        if (jogoSalvo.isPresent()) {
            Jogo jogo = jogoSalvo.get();
            jogo.setTitulo((jogoRequestDTO.getTitulo()));
            jogo.setPreco((jogoRequestDTO.getPreco()));
            jogo.setEstoque((jogoRequestDTO.getEstoque()));
            jogo.setClassificacaoIndicativa((jogoRequestDTO.getClassificacaoIndicativa()));
            return JogoResponseDTO.entityToDto(jogoRepository.save(jogo));
        }
        throw new RuntimeException("Esse ID não existe!");

    }

    public void deleteById(long id) {
        jogoRepository.deleteById(id);
    }
}
