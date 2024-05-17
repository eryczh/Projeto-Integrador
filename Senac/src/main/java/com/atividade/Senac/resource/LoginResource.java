package com.atividade.Senac.resource;

import com.atividade.Senac.Entities.Login;
import com.atividade.Senac.services.DBServiceLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/login")
public class LoginResource {

    @Autowired
    private DBServiceLogin dbServiceLogin;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Login> findById(@PathVariable Integer id) {
      Login login = dbServiceLogin.findByIdLogin(id);
      return ResponseEntity.ok().body(login);
    }

    @GetMapping
    public List<Login> ListarTodosLogins() {
      List<Login> login = dbServiceLogin.ListarTodosLogins();
      return login;
    }

    @PostMapping
    public ResponseEntity<Login> gravarLogin(@RequestBody Login login) {
      login = dbServiceLogin.gravarLogin(login);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(login.getId()).toUri();
      return ResponseEntity.created(uri).body(login);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
      dbServiceLogin.deletarLogin(id);
      return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Login> update(@PathVariable Integer id, @RequestBody Login login) {
      Login alterado = dbServiceLogin.updateLogin(id, login);
      return ResponseEntity.ok().body(alterado);
    }
}