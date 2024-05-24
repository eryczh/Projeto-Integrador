package com.atividade.Senac.Repository;

import com.atividade.Senac.Entities.Aluguel;
import com.atividade.Senac.Entities.Imovel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AluguelRepository extends JpaRepository <Aluguel, Integer>{

    @Query("SELECT alugueis FROM Alugueis alugueis "
    + "WHERE alugueis.id!=null ORDER BY alugueis.nomeCliente")
    List<Aluguel> listarAlugueisComId();

    @Query("SELECT alugueis FROM Alugueis alugueis "
    + "WHERE alugueis.id!= null ORDER BY alugueis.nomeCliente")
    List<Aluguel> listarAlugueisSemId();

    @Query("SELECT alugueis FROM Alugueis alugueis WHERE alugueis.cpf = :cpf")
    List<Aluguel> findByCpf(String cpf);

    Optional<Aluguel> findByImovel(Imovel imovel);
}