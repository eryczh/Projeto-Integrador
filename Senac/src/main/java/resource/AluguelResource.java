package resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Entities.Aluguel;
import services.DBService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



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

    @GetMapping(value = "nome/{nome}")
    public ResponseEntity<Aluguel> findByNomeAluguel (@PathVariable String nome) {
        Aluguel aluguel = dbService.findByNomeAluguel(nome);
        return ResponseEntity.ok().body(aluguel);
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
