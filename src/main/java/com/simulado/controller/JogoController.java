package com.simulado.controller;

import com.simulado.dto.JogoRequestDTO;
import com.simulado.dto.JogoResponseDTO;
import com.simulado.service.JogoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/Jogos")
public class JogoController {
@Autowired
    private JogoService jogoService;
@PostMapping
public  JogoResponseDTO save(@Valid @RequestBody JogoRequestDTO jogoRequestDTO) {return jogoService.save(jogoRequestDTO);
}
@GetMapping("{id}")
    public  JogoResponseDTO findById(@PathVariable Long id){return jogoService.findById(id);
}
@GetMapping
    public java.util.List<JogoResponseDTO> findAll() {return jogoService.findAll();
}
@PutMapping("{id}")
public  JogoResponseDTO update(@PathVariable Long id, @Valid @RequestBody JogoRequestDTO jogoRequestDTO) {
    return jogoService.update(id, jogoRequestDTO);

}
@DeleteMapping("{id}")
    public void delete(@PathVariable Long id){ jogoService.delete(id);}
}
