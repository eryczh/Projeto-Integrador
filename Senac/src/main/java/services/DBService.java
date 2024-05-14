package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import Entities.Imovel;
import Repository.ImovelRepository;

@Service
public class DBService {
    
    @Autowired
    private ImovelRepository imovelRepository;

    public Imovel findById (Integer id) {
        Optional<Imovel> imovel = imovelRepository.findById(id);
        return imovel.orElse(null);
    }

    public List<Imovel> listarTodos() {
        List<Imovel> imovel = imovelRepository.findAll();
        return imovel;
    }

    public Imovel findByNome(String nome) {
        Optional<Imovel> imovel = imovelRepository.findByNome(nome);
        return imovel.orElse(null);
    }

    public Imovel gravarImovel(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public void deletar(Integer id) {
        imovelRepository.deleteById(id);
    }

    public Imovel update (Integer id, Imovel imovel) {
        Imovel alterado = findById(id);
        if (alterado != null) {
            alterado.setNome(imovel.getNome());
            alterado.setCidade(imovel.getCidade());
            alterado.setEndereco(imovel.getEndereco());
            alterado.setCEP(imovel.getCEP());
            alterado.setNumero(imovel.getNumero());
            alterado.setTipo(imovel.getTipo());
            alterado.setValor(imovel.getValor());
            alterado.setAlugada(imovel.getAlugada());
            
            return imovelRepository.save(alterado);
        }
        
        return null;
    }

}
