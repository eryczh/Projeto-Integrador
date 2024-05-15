package com.atividade.Senac.configurations;

import com.atividade.Senac.services.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("teste")
public class TesteConfiguracao {
    
    @Autowired
    AluguelService myAluguelService;

    private boolean instanciar() throws ParseException {
        this.myAluguelService.instanciarDB();
        return true;
    }
}
