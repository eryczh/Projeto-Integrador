package com.atividade.Senac.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.atividade.Senac.Entities.Aluguel;
import com.atividade.Senac.Entities.Imovel;
import com.atividade.Senac.Repository.AluguelRepository;
import com.atividade.Senac.Repository.ImovelRepository;

@Service
public class AluguelService {
    
    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ImovelRepository imovelRepository;

    @Bean
    public void instanciarDBAluguel() {
        Imovel imovel1 = new Imovel("Eric P2", "Piaui", "Rua Corinto Andrade, Pedro II", "64255-000", "11", "Casa", 50.99, true);
        imovelRepository.saveAll(Arrays.asList(imovel1));

        imovel1 = imovelRepository.getById(1);

        Aluguel aluguel1 = new Aluguel("Eric p.a", "48805895865", "Cartão de Crédito", imovel1);
        aluguelRepository.saveAll(Arrays.asList(aluguel1));
    }
}
