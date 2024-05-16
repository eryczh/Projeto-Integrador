package com.atividade.Senac.configurations;

import com.atividade.Senac.services.AluguelService;
import com.atividade.Senac.services.ImovelService;
import com.atividade.Senac.services.LoginService;

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
    ImovelService myImovelService;

    @Autowired
    LoginService myLoginService;

    private boolean instanciar() throws ParseException {
        this.myAluguelService.instanciarDBAluguel();
        this.myImovelService.instanciarDBImovel();
        this.myLoginService.instanciarDBLogin();
        
        return true;
    }
}