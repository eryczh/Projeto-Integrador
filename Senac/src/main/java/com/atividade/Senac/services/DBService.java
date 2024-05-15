package com.atividade.Senac.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.Senac.Entities.Aluguel;
import com.atividade.Senac.Repository.AluguelRepository;

import java.util.Optional;
import java.util.List;

@Service
public class DBService {
    

    @Autowired
    private AluguelRepository aluguelRepository;

    public Aluguel findByIdAluguel (Integer id) {
        Optional<Aluguel> aluguel = aluguelRepository.findById(id);
        return aluguel.orElse(null);
    }



    public List<Aluguel> listarTodosAlugueis() {
        List<Aluguel> aluguel = aluguelRepository.findAll();
        return aluguel;
    }


    public Aluguel gravarAluguel(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }


    public void deletarAluguel(Integer id) {
        aluguelRepository.deleteById(id);
    }



    public Aluguel updateAluguel (Integer id, Aluguel aluguel) {
        Aluguel alterado = findByIdAluguel(id);
        if (alterado != null) {
            alterado.setNomeCliente(aluguel.getNomeCliente());
            alterado.setCpf(aluguel.getCpf());
            alterado.setFormaDePagamento(aluguel.getFormaDePagamento());

            return aluguelRepository.save(alterado);
        }
        return null;
    }

    

}