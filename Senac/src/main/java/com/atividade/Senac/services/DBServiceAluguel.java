package com.atividade.Senac.services;

import com.atividade.Senac.Entities.Aluguel;
import com.atividade.Senac.Entities.Imovel;
import com.atividade.Senac.Repository.AluguelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBServiceAluguel {
    
    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private DBServiceImovel imovelServiceI;

    public Aluguel findByIdAluguel (Integer id) {
        Optional<Aluguel> aluguel = aluguelRepository.findById(id);
        return aluguel.orElse(null);
    }

    
    public List<Aluguel> listarTodosAlugueis() {
        List<Aluguel> aluguel = aluguelRepository.findAll();
        return aluguel;
    }

    public Aluguel gravarAluguel(Aluguel aluguel) {
        Imovel imovel = (aluguel.getImovel());
        imovelServiceI.alugarImovel(imovel.getId(), imovel);
        return aluguelRepository.save(aluguel);
    }

    public void deletarAluguel(Integer id) {
        Aluguel aluguel = findByIdAluguel(id);
        Imovel imovel = (aluguel.getImovel());
        imovelServiceI.disponibilizarImovel(imovel.getId(), imovel);
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

    public List<Aluguel> buscarPorCPF(String cpf) {
        return aluguelRepository.findByCpf(cpf);
    }
}