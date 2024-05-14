package Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Entities.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository <Aluguel, Integer>{

    @Query("SELECT alugueis FROM Aluguel alugueis"
    + "WHERE alugueis.id!=null ORDER BY alugueis.nome")
    List<Aluguel> listarAlugueisComId();

    @Query("SELECT alugueis FROM Aluguel alugueis"
    + "WHERE alugueis!= null ORDER BY alugueis.nome")
    List<Aluguel> listarAlugueisSemId();
    

    Optional<Aluguel> findByNome(String nome);
}
