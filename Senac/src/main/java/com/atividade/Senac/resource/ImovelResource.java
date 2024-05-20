package com.atividade.Senac.resource;

import com.atividade.Senac.Entities.Imovel;
import com.atividade.Senac.services.DBServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 33600)
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

    // Novo endpoint: buscar imóveis por tipo
    @GetMapping(value = "/tipo/{tipo}")
    public ResponseEntity<List<Imovel>> listarImoveisPorTipo(@PathVariable String tipo) {
        List<Imovel> imoveis = dbServiceImovel.listarImoveisPorTipo(tipo);
        return ResponseEntity.ok().body(imoveis);
    }

    // Novo endpoint: buscar imóveis por CEP
    @GetMapping(value = "/cep/{cep}")
    public ResponseEntity<List<Imovel>> listarImoveisPorCep(@PathVariable String cep) {
        List<Imovel> imoveis = dbServiceImovel.listarImoveisPorCep(cep);
        return ResponseEntity.ok().body(imoveis);
    }

    // Novo endpoint: buscar imóveis por tipo e CEP
    @GetMapping(value = "/tipo/{tipo}/cep/{cep}")
    public ResponseEntity<List<Imovel>> listarImoveisPorTipoECep(@PathVariable String tipo, @PathVariable String cep) {
        List<Imovel> imoveis = dbServiceImovel.listarImoveisPorTipoECep(tipo, cep);
        return ResponseEntity.ok().body(imoveis);
    }

    @GetMapping(value = "/alugado")
    public ResponseEntity<List<Imovel>> listarImoveisAlugados() {
        List<Imovel> imoveis = dbServiceImovel.listarImoveisAlugados();
        return ResponseEntity.ok().body(imoveis);
    }

    @GetMapping(value = "/disponivel")
    public ResponseEntity<List<Imovel>> listarImoveisDisponiveis() {
        List<Imovel> imoveis = dbServiceImovel.listarImoveisDiisponiveis();
        return ResponseEntity.ok().body(imoveis);
    }
}
