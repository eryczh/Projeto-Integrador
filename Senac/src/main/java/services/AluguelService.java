package services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import Entities.Aluguel;
import Repository.AluguelRepository;

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
