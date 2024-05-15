package com.atividade.Senac.resource;

import com.atividade.Senac.Entities.Aluguel;
import com.atividade.Senac.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/aluguel")
public class AluguelResource {
    
    @Autowired
    private DBService dbService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluguel> findById(@PathVariable Integer id) {
        Aluguel aluguel = dbService.findByIdAluguel(id);
        return ResponseEntity.ok().body(aluguel);
    }

    @GetMapping
    public List<Aluguel> listarTodosAlugueis() {
        List<Aluguel> alugueis = dbService.listarTodosAlugueis();
        return alugueis;
    }

    @PostMapping
    public ResponseEntity<Aluguel> gravarAluguel(@RequestBody Aluguel aluguel) {
        aluguel = dbService.gravarAluguel(aluguel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluguel.getId()).toUri();
        
        return ResponseEntity.created(uri).body(aluguel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        dbService.deletarAluguel(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluguel> update(@PathVariable Integer id, @RequestBody Aluguel aluguel) {
        Aluguel alterado = dbService.updateAluguel(id, aluguel);
        return ResponseEntity.ok().body(alterado);
    }
}