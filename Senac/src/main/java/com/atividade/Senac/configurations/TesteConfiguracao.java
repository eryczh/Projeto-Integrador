package com.atividade.Senac.configurations;

import com.atividade.Senac.services.AluguelService;
import com.atividade.Senac.services.LoginService;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("teste")
public class TesteConfiguracao {
    
    @Autowired
    AluguelService myAluguelService;
    
    @Autowired
    LoginService loginService;

    @PostConstruct
    private boolean instanciar() throws ParseException {
       
        this.myAluguelService.instanciarDBAluguel();
        this.loginService.instanciarDBLogin();
        return true;
    }
}