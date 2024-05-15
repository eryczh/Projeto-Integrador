package com.atividade.Senac.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.atividade.Senac.Entities.Login;
import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository <Login, Integer> {

    @Query("SELECT login From Login login "
    + "WHERE login.id!=null ORDER BY login.user")
    List<Login> listarLoginComID();
    
    @Query("SELECT login From Login login "
    + "WHERE login.id!=null ORDER BY login.user")
    List<Login> listarLoginSemID();
    
}