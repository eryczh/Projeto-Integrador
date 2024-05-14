package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import Entities.Aluguel;
import Entities.Imovel;
import Repository.AluguelRepository;
import Repository.ImovelRepository;

@Service
public class DBService {
    
    @Autowired
    private ImovelRepository imovelRepository;
    private AluguelRepository aluguelRepository;


    public Imovel findByIdImovel (Integer id) {
        Optional<Imovel> imovel = imovelRepository.findById(id);
        return imovel.orElse(null);
    }

    public Aluguel findByIdAluguel (Integer id) {
        Optional<Aluguel> aluguel = aluguelRepository.findById(id);
        return aluguel.orElse(null);
    }

    public List<Imovel> listarTodosImoveis() {
        List<Imovel> imovel = imovelRepository.findAll();
        return imovel;
    }

    public List<Aluguel> listarTodosAlugueis() {
        List<Aluguel> aluguel = aluguelRepository.findAll();
        return aluguel;
    }
    

    public Imovel findByNomeImovel(String nome) {
        Optional<Imovel> imovel = imovelRepository.findByNome(nome);
        return imovel.orElse(null);
    }

    public Aluguel findByNomeAluguel(String nome) {
        Optional<Aluguel> aluguel = aluguelRepository.findByNome(nome);
        return aluguel.orElse(null);
    }

    public Imovel gravarImovel(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public Aluguel gravarAluguel(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    public void deletarImovel(Integer id) {
        imovelRepository.deleteById(id);
    }

    public void deletarAluguel(Integer id) {
        aluguelRepository.deleteById(id);
    }

    public Imovel updateImovel (Integer id, Imovel imovel) {
        Imovel alterado = findByIdImovel(id);
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
