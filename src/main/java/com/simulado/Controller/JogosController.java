package com.simulado.Controller;

import com.simulado.Repository.JogosRepository;
import com.simulado.Service.JogosService;
import com.simulado.dtos.JogosRequestDTO;
import com.simulado.dtos.JogosResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({"api/jogos"})

public class JogosController {
    @Autowired
    private JogosService jogosService;

    @PostMapping
    public JogosResponseDTO save(@RequestBody @Valid JogosRequestDTO jogosRequestDTO) {
        return jogosService.save(jogosRequestDTO);
    }

    @GetMapping("/{id}")
    public JogosResponseDTO findById(@PathVariable Long id){
        return jogosService.findById(id);
    }

    @GetMapping
    public java.util.List<JogosResponseDTO> findAll(){
        return jogosService.findAll();
    }

    @PutMapping("/{id}")
    public JogosResponseDTO update (@PathVariable Long id, @Valid @RequestBody JogosRequestDTO jogosRequestDTO) {
        return jogosService.update(id, jogosRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        jogosService.delete(id);
    }

}
