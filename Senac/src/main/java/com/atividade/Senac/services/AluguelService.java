package com.atividade.Senac.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.atividade.Senac.Entities.Aluguel;
import com.atividade.Senac.Repository.AluguelRepository;

@Service
public class AluguelService {
    
    @Autowired
    private AluguelRepository aluguelRepository;
    @Bean
    public void instanciarDB() {
        Aluguel aluguel1 = new Aluguel("Eric p.a", "333-333-333-00", "Cartão de Crédito");
        aluguelRepository.saveAll(Arrays.asList(aluguel1));
    }
}
