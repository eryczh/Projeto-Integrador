package com.atividade.Senac.Repository;

import java.util.List;
import java.util.Optional;

import com.atividade.Senac.Entities.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository <Aluguel, Integer>{

    @Query("SELECT alugueis FROM Alugueis alugueis "
    + "WHERE alugueis.id!=null ORDER BY alugueis.nomeCliente")
    List<Aluguel> listarAlugueisComId();

    @Query("SELECT alugueis FROM Alugueis alugueis "
    + "WHERE alugueis.id!= null ORDER BY alugueis.nomeCliente")
    List<Aluguel> listarAlugueisSemId();

}