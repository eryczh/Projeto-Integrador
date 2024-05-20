package com.atividade.Senac.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atividade.Senac.Entities.Login;
import com.atividade.Senac.services.DBSeviceLogin;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "*", maxAge = 33600)
@RestController
@RequestMapping(value = "/login")
public class LoginResource {

    @Autowired
    private DBSeviceLogin dbSeviceLogin;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Login> findById(@PathVariable Integer id) {
        Login login = dbSeviceLogin.findByIdLogin(id);
        return ResponseEntity.ok().body(login);
    }

    @GetMapping
    public List<Login> listarTodosLogin() {
        List<Login> loguin = dbSeviceLogin.listarOsLogins();
        return loguin;
    } 

    @GetMapping(value = "/entrar/{user}/{senha}")
    public ResponseEntity<Boolean> buscarLogin(@PathVariable String user, @PathVariable String senha) {
        Login login = dbSeviceLogin.buscarLogin(user, senha);
        if (login != null) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping
    public ResponseEntity<Login> gravarLogin(@RequestBody Login login) {
        login = dbSeviceLogin.gravarLogin(login);
        URI rui =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(login.getId()).toUri();
    
        return ResponseEntity.created(rui).body(login);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        dbSeviceLogin.deletarLogin(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Login> update(@PathVariable Integer id, String user, String senha, @RequestBody Login login) {
        Login alterado = dbSeviceLogin.updateLogin(id, user, senha);
        return ResponseEntity.ok().body(alterado);
    }
}
