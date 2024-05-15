package com.atividade.Senac.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.atividade.Senac.Entities.Imovel;
import com.atividade.Senac.Repository.ImovelRepository;


@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;
    @Bean
    public void instanciarDBImovel() {
        Imovel imovel1 = new Imovel("Imovel belo", "SP", "Rua euzebio", "0000-11", 11, "CASA", 3.000, false);
        imovelRepository.saveAll(Arrays.asList(imovel1));
    }
}
