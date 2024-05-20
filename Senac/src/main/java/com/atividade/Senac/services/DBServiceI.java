package com.atividade.Senac.services;

import com.atividade.Senac.Entities.Imovel;
import com.atividade.Senac.Repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBServiceI {

    @Autowired
    private ImovelRepository imovelRepository;

    public Imovel findByIdImovel (Integer id) {
        Optional<Imovel> imovel = imovelRepository.findById(id);
        return imovel.orElse(null);
    }

    public List<Imovel> listarTodosImoveis() {
        List<Imovel> imovel = imovelRepository.findAll();
        return imovel;
    }

    public Imovel gravarImovel(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public void deletarImovel(Integer id) {
        imovelRepository.deleteById(id);
    }

    public Imovel updateImovel (Integer id, Imovel imovel) {
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

    public List<Imovel> listarImoveisPorTipo(String tipo) {
        return imovelRepository.listarImoveisPorTipo(tipo);
    }

    public List<Imovel> listarImoveisPorCep(String cep) {
        return imovelRepository.listarImoveisPorCep(cep);
    }

    public List<Imovel> listarImoveisPorTipoECep(String tipo, String cep) {
        return imovelRepository.listarImoveisPorTipoECep(tipo, cep);
    }

    public List<Imovel> listarImoveisAlugados() {
        return imovelRepository.findByAlugadaTrue();
    }

    public List<Imovel> listarImoveisDiisponiveis() {
        return imovelRepository.findByAlugadaFalse();
    }
}
