package com.atividade.Senac.services;

import com.atividade.Senac.Entities.Imovel;
import com.atividade.Senac.Entities.Aluguel;
import com.atividade.Senac.Repository.ImovelRepository;
import com.atividade.Senac.Repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBServiceImovel {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

    public Imovel findByIdImovel(Integer id) {
        Optional<Imovel> imovel = imovelRepository.findById(id);
        return imovel.orElse(null);
    }

    public List<Imovel> listarTodosImoveis() {
        return imovelRepository.findAll();
    }

    public Imovel gravarImovel(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public void deletarImovel(Integer id) {
        Optional<Imovel> imovel = imovelRepository.findById(id);
        if (imovel.isPresent()) {
            if (imovel.get().isAlugada()) {
                Optional<Aluguel> aluguel = aluguelRepository.findByImovel(imovel.get());
                aluguel.ifPresent(aluguelRepository::delete);
            }
            imovelRepository.deleteById(id);
        } else {
            throw new RuntimeException("Imóvel não encontrado");
        }
    }

    public Imovel updateImovel(Integer id, Imovel imovel) {
        Imovel alterado = findByIdImovel(id);
        if (alterado != null) {
            alterado.setNome(imovel.getNome());
            alterado.setEstado(imovel.getEstado());
            alterado.setEndereco(imovel.getEndereco());
            alterado.setCEP(imovel.getCEP());
            alterado.setNumero(imovel.getNumero());
            alterado.setTipo(imovel.getTipo());
            alterado.setValor(imovel.getValor());
            alterado.setAlugada(imovel.isAlugada());

            return imovelRepository.save(alterado);
        }

        return null;
    }

    public Imovel alugarImovel(Integer id, Imovel imovelEnviado) {
        Imovel imovel = findByIdImovel(id);

        imovel.setAlugada(true);

        return imovelRepository.save(imovel);
    }

    public Imovel disponibilizarImovel(Integer id, Imovel imovelEnviado) {
        Imovel imovel = findByIdImovel(id);

        imovel.setAlugada(false);

        return imovelRepository.save(imovel);
    }

    public List<Imovel> listarImoveisPorTipo(String tipo) {
        return imovelRepository.listarImoveisPorTipo(tipo);
    }

    public List<Imovel> listarImoveisPorCep(String cep) {
        return imovelRepository.listarImoveisPorCep(cep);
    }

    public List<Imovel> listarImoveisPorTipoECep(String tipo, String cep) {
        return imovelRepository.listarImoveisPorTipoECep(tipo, cep);
    }

    public List<Imovel> listaImoveisPorEndereco(String endereco, String numero) {
        return imovelRepository.findByEnderecoAndNumero(endereco, numero);
    }

    public List<Imovel> listarImoveisAlugados() {
        return imovelRepository.findByAlugadaTrue();
    }

    public List<Imovel> listarImoveisDisponiveis() {
        return imovelRepository.findByAlugadaFalse();
    }
}
