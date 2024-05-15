package com.atividade.Senac.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.Senac.Entities.Login;
import com.atividade.Senac.Repository.LoginRepository;

@Service
public class DBServiceLogin {

    @Autowired
    private LoginRepository loginRepository;

    public Login findByIdLogin (Integer id) {
        Optional<Login> login = loginRepository.findByI
    }
    
}