package com.simulado.controller;

import com.simulado.dto.JogoRequestDTO;
import com.simulado.dto.JogoResponseDTO;
import com.simulado.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public List<JogoResponseDTO> findAll() {
        return jogoService.findAll();
    }

    @GetMapping("/{id}")
    public JogoResponseDTO findJogoById(Long id) {
        return jogoService.findJogoById(id);
    }

    @PostMapping
    public JogoResponseDTO save(JogoRequestDTO jogoRequestDTO) {
        return jogoService.save(jogoRequestDTO);
    }

    @PutMapping
    public JogoResponseDTO update(Long id, JogoRequestDTO jogoRequestDTO) {
        return jogoService.update(id, jogoRequestDTO);
    }

    @DeleteMapping
    public void delete(Long id) {
        jogoService.delete(id);
    }

}
