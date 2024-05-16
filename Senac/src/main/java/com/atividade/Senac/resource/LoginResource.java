package com.atividade.Senac.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.Senac.Entities.Login;
import com.atividade.Senac.services.DBServiceLogin;

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
}