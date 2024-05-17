package com.atividade.Senac.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.atividade.Senac.Entities.Login;

@Repository
public interface LoginRepository extends JpaRepository <Login, Integer>{
  
@Query("SELECT Login FROM Login login "
    + "WHERE login.id!=null ORDER BY login.user")
    List<Login> listarLoginsComId();

    @Query("SELECT Login FROM Login login "
    + "WHERE login.id!= null ORDER BY login.user")
    List<Login> listarLoginsSemId();

}
