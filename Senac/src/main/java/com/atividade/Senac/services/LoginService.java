package com.atividade.Senac.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.atividade.Senac.Entities.Login;
import com.atividade.Senac.Repository.LoginRepository;

@Service
public class LoginService {
    
    @Autowired
    private LoginRepository loginRepository;
    @Bean
    public void instanciarDBLogin() {
        Login login = new Login("admin", "1234");
        loginRepository.saveAll(Arrays.asList(login));
    }
}
