package services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import Entities.Imovel;
import Repository.ImovelRepository;


@Service
public class ImovelService {
    
    @Autowired
    private ImovelRepository imovelRepository;
    @Bean
    public void instanciarDB() {
        Imovel imovel1 = new Imovel("Imovel belo", "SP", "Rua euzebio", "0000-11", 11, "CASA", 3.000, false);
        imovelRepository.saveAll(Arrays.asList(imovel1));
    }
}
