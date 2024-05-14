package resource;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Entities.Imovel;
import services.DBService;

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
    private DBService dbService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Imovel> findById(@PathVariable Integer id) {
        Imovel imovel = dbService.findById(id);
        return ResponseEntity.ok().body(imovel);
    }

    @GetMapping
    public List<Imovel> listarTodos() {
        List<Imovel> imoveis = dbService.listarTodos();
        return imoveis;
    }

    @GetMapping(value = "nome/{nome}")
    public ResponseEntity<Imovel> findByNome (@PathVariable String nome) {
        Imovel imovel = dbService.findByNome(nome);
        return ResponseEntity.ok().body(imovel);
    }

    @PostMapping 
    public ResponseEntity<Imovel> gravarImovel(@RequestBody Imovel imovel) {
        imovel = dbService.gravarImovel(imovel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(imovel.getId()).toUri();
    
        return ResponseEntity.created(uri).body(imovel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        dbService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Imovel> update(@PathVariable Integer id, @RequestBody Imovel imovel) {
        Imovel alterado = dbService.update(id, imovel);
        return ResponseEntity.ok().body(alterado);
    }


    
    
    
}
