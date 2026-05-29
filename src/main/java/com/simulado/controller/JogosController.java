package com.simulado.controller;

import com.simulado.dto.JogosRequestDTO;
import com.simulado.dto.JogosResponseDTO;
import com.simulado.service.JogosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/jogos")
public class JogosController {
    @Autowired
    private JogosService jogosService;

    @PostMapping
    public JogosResponseDTO save(@Valid @RequestBody JogosRequestDTO jogosRequestDTO) {
        return jogosService.save(jogosRequestDTO);
    }

    @GetMapping("{id}")
    public JogosResponseDTO findById(@PathVariable Long id) {
        return jogosService.findById(id);
    }

    @GetMapping
    public List<JogosResponseDTO> findAll() {
        return jogosService.findAll();
    }

    @PutMapping("{id}")
    public JogosResponseDTO update(@PathVariable Long id, @Valid @RequestBody JogosRequestDTO jogosRequestDTO) {
        return jogosService.update(id, jogosRequestDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        jogosService.delete(id);
    }
}
