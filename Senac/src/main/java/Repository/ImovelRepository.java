package Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Entities.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository <Imovel, Integer> {

    @Query("SELECT imoveis FROM Imoveis imoveis"
    + "WHERE imoveis.id!=null ORDER BY imoveis.nome")
    List<Imovel> listarImoveisComID();

    @Query("SELECT imoveis FROM Imoveis imoveis "
    + "WHERE imoveis.id!= ORDER BY imoveis.nome")
    List<Imovel> listarImoveisSemId();

    Optional<Imovel> findByNome(String nome);
}
