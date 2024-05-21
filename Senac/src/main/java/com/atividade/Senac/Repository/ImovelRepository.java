package com.atividade.Senac.Repository;

import com.atividade.Senac.Entities.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer> {

    @Query("SELECT imoveis FROM Imoveis imoveis WHERE imoveis.id != null ORDER BY imoveis.nome")
    List<Imovel> listarImoveisComID();

    @Query("SELECT imoveis FROM Imoveis imoveis WHERE imoveis.id != null ORDER BY imoveis.nome")
    List<Imovel> listarImoveisSemId();

    @Query("SELECT imoveis FROM Imoveis imoveis WHERE imoveis.tipo = :tipo")
    List<Imovel> listarImoveisPorTipo(String tipo);

    @Query("SELECT imoveis FROM Imoveis imoveis WHERE imoveis.cep = :cep")
    List<Imovel> listarImoveisPorCep(String cep);

    @Query("SELECT imoveis FROM Imoveis imoveis WHERE imoveis.tipo = :tipo AND imoveis.cep = :cep")
    List<Imovel> listarImoveisPorTipoECep(String tipo, String cep);

    @Query("SELECT imoveis FROM Imoveis imoveis WHERE imoveis.endereco = :endereco AND imoveis.numero = :numero")
    List<Imovel> findByEnderecoAndNumero(String endereco, String numero);

    @Query("SELECT imoveis FROM Imoveis imoveis WHERE imoveis.alugada = false")
    List<Imovel> findByAlugadaFalse();

    @Query("SELECT imoveis FROM Imoveis imoveis WHERE imoveis.alugada = true")
    List<Imovel> findByAlugadaTrue();
}
