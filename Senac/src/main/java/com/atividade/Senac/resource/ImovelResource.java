package com.atividade.Senac.resource;


import java.net.URI;
import java.util.List;

import com.atividade.Senac.services.DBServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atividade.Senac.Entities.Imovel;
import com.atividade.Senac.services.DBService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(value = "/imovel")
public class ImovelResource {

    @Autowired
    private DBServiceI dbService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Imovel> findById(@PathVariable Integer id) {
        Imovel imovel = dbService.findByIdImovel(id);
        return ResponseEntity.ok().body(imovel);
    }

    @GetMapping
    public List<Imovel> listarTodosImoveis() {
        List<Imovel> imoveis = dbService.listarTodosImoveis();
        return imoveis;
    }

    @PostMapping
    public ResponseEntity<Imovel> gravarImovel(@RequestBody Imovel imovel) {
        imovel = dbService.gravarImovel(imovel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(imovel.getId()).toUri();

        return ResponseEntity.created(uri).body(imovel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        dbService.deletarImovel(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Imovel> update(@PathVariable Integer id, @RequestBody Imovel imovel) {
        Imovel alterado = dbService.updateImovel(id, imovel);
        return ResponseEntity.ok().body(alterado);
    }
}