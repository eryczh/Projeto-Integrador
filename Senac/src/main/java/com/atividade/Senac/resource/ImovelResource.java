package com.atividade.Senac.resource;

import com.atividade.Senac.Entities.Imovel;
import com.atividade.Senac.services.DBServiceImovel;
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
    private DBServiceImovel dbServiceImovel;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Imovel> findById(@PathVariable Integer id) {
        Imovel imovel = dbServiceImovel.findByIdImovel(id);
        return ResponseEntity.ok().body(imovel);
    }

    @GetMapping
    public List<Imovel> listarTodosImoveis() {
        return dbServiceImovel.listarTodosImoveis();
    }

    @PostMapping
    public ResponseEntity<Imovel> gravarImovel(@RequestBody Imovel imovel) {
        imovel = dbServiceImovel.gravarImovel(imovel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(imovel.getId()).toUri();
        return ResponseEntity.created(uri).body(imovel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            dbServiceImovel.deletarImovel(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Imovel> update(@PathVariable Integer id, @RequestBody Imovel imovel) {
        Imovel alterado = dbServiceImovel.updateImovel(id, imovel);
        return ResponseEntity.ok().body(alterado);
    }

    @PutMapping(value = "/disponibilizar/{id}")
    public ResponseEntity<Imovel> disponibilizar(@PathVariable Integer id, @RequestBody Imovel imovel) {
        dbServiceImovel.disponibilizarImovel(id, imovel);
        return ResponseEntity.status(200).build();
    }

    @PutMapping(value = "/alugar/{id}")
    public ResponseEntity<Imovel> alugar(@PathVariable Integer id, @RequestBody Imovel imovel) {
        dbServiceImovel.alugarImovel(id, imovel);
        return ResponseEntity.status(200).build();
    }

    @GetMapping(value = "/tipo/{tipo}")
    public ResponseEntity<List<Imovel>> listarImoveisPorTipo(@PathVariable String tipo) {
        List<Imovel> imoveis = dbServiceImovel.listarImoveisPorTipo(tipo);
        return ResponseEntity.ok().body(imoveis);
    }

    @GetMapping(value = "/cep/{cep}")
    public ResponseEntity<List<Imovel>> listarImoveisPorCep(@PathVariable String cep) {
        List<Imovel> imoveis = dbServiceImovel.listarImoveisPorCep(cep);
        return ResponseEntity.ok().body(imoveis);
    }

    @GetMapping(value = "/tipo/{tipo}/cep/{cep}")
    public ResponseEntity<List<Imovel>> listarImoveisPorTipoECep(@PathVariable String tipo, @PathVariable String cep) {
        List<Imovel> imoveis = dbServiceImovel.listarImoveisPorTipoECep(tipo, cep);
        return ResponseEntity.ok().body(imoveis);
    }

    @GetMapping(value = "/endereco/{endereco}/{numero}")
    public ResponseEntity<List<Imovel>> listaImoveisPorEndereco(@PathVariable String endereco, @PathVariable String numero) {
        List<Imovel> imoveis = dbServiceImovel.listaImoveisPorEndereco(endereco, numero);
        return ResponseEntity.ok().body(imoveis);
    }

    @GetMapping(value = "/alugado")
    public ResponseEntity<List<Imovel>> listarImoveisAlugados() {
        List<Imovel> imoveis = dbServiceImovel.listarImoveisAlugados();
        return ResponseEntity.ok().body(imoveis);
    }

    @GetMapping(value = "/disponivel")
    public ResponseEntity<List<Imovel>> listarImoveisDisponiveis() {
        List<Imovel> imoveis = dbServiceImovel.listarImoveisDisponiveis();
        return ResponseEntity.ok().body(imoveis);
    }
}
