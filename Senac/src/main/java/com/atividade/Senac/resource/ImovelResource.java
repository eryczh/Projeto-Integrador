package com.atividade.Senac.resource;

import com.atividade.Senac.Entities.Imovel;
import com.atividade.Senac.services.DBServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/imovel")
public class ImovelResource {

    @Autowired
    private DBServiceI dbServiceImovel;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Imovel> findById(@PathVariable Integer id) {
        Imovel imovel = dbServiceImovel.findByIdImovel(id);
        return ResponseEntity.ok().body(imovel);
    }

    @GetMapping
    public List<Imovel> listarTodosImoveis() {
        List<Imovel> imoveis = dbServiceImovel.listarTodosImoveis();
        return imoveis;
    }

    @PostMapping
    public ResponseEntity<Imovel> gravarImovel(@RequestBody Imovel imovel) {
        imovel = dbServiceImovel.gravarImovel(imovel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(imovel.getId()).toUri();

        return ResponseEntity.created(uri).body(imovel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        dbServiceImovel.deletarImovel(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Imovel> update(@PathVariable Integer id, @RequestBody Imovel imovel) {
        Imovel alterado = dbServiceImovel.updateImovel(id, imovel);
        return ResponseEntity.ok().body(alterado);
    }
}