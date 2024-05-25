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
        Imovel imovel1 = new Imovel("P2", "Piaui", "Rua Corinto Andrade, Pedro II", "64255-000", "11", "Casa", 300.50, true);
        Imovel imovel2 = new Imovel("Tamboré", "São Paulo", "Alameda Kioto, Tamboré, Santana de Parnaíba", "06543-045", "12 Andar:1 101", "Apartamento", 569.00, false);
        Imovel imovel3 = new Imovel("Tamboré", "São Paulo", "Alameda Kioto, Tamboré, Santana de Parnaíba", "06543-045", "12 Andar:2 201", "Apartamento", 569.00, false);
        Imovel imovel4 = new Imovel("Tamboré", "São Paulo", "Alameda Kioto, Tamboré, Santana de Parnaíba", "06543-045", "12 Andar:3 301", "Apartamento", 569.00, false);
        Imovel imovel5 = new Imovel("Tamboré", "São Paulo", "Alameda Kioto, Tamboré, Santana de Parnaíba", "06543-045", "12 Andar:1 401", "Apartamento", 569.00, true);
        Imovel imovel6 = new Imovel("Marçola", "Minas Gerais", "Rua da Água, Marçola, Belo Horizonte", "30220-340", "320", "Casa", 450.00, false);
        Imovel imovel7 = new Imovel("Vila Natal", "Minas Gerais", "Rua Pêra Natal, Vila Natal, São Paulo", "04863-320", "120", "Casa", 350.00, false);
        Imovel imovel8 = new Imovel("Rua Dom Pedro II", "Bahia", "Rua Dom Pedro II, Xique-Xique", "47400-000", "5000", "Kitnet", 800.80, false);
        imovelRepository.saveAll(Arrays.asList(imovel1, imovel2, imovel3, imovel4, imovel5, imovel6, imovel7, imovel8));

        Aluguel aluguel1 = new Aluguel("Eric Palmeiras Andre", "48805895865", "Cartão de Crédito", imovel1);
        Aluguel aluguel2 = new Aluguel("Alexandra Silva Palmares", "47800768899", "PIX", imovel5);
        aluguelRepository.saveAll(Arrays.asList(aluguel1, aluguel2));
    }
}
