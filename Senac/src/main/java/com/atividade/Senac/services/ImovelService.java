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
        Imovel imovel1 = new Imovel("Eric P2", "Piaui", "Rua Corinto Andrade, Pedro II", "64255-000", 11, "Casa", 50.99, false);
        Imovel imovel2 = new Imovel("Tamboré", "São Paulo", "Alameda Kioto, Tamboré, Santana de Parnaíba", "06543-045", 0, "Apartamento", 569.00, true);
        Imovel imovel3 = new Imovel("Marçola", "Minas Gerais", "Rua da Água, Marçola, Belo Horizonte", "30220-340", 320, "Casa", 350.00, false);
        Imovel imovel4 = new Imovel("Rua Dom Pedro II", "Bahia", "Rua Dom Pedro II, Xique-Xique", "47400-000", 5000, "Kitnet", 800.00, false);

        imovelRepository.saveAll(Arrays.asList(imovel1, imovel2, imovel3, imovel4));
    }
}
