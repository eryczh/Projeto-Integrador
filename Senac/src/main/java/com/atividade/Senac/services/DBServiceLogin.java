package com.atividade.Senac.services;

import com.atividade.Senac.Entities.Login;
import com.atividade.Senac.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBServiceLogin {

    @Autowired
    private LoginRepository loginRepository;

    public Login findByIdLogin (Integer id) {
        Optional<Login> login = loginRepository.findById(id);
        return login.orElse(null);
    }

    public List<Login> ListarTodosLogins() {
        List<Login> login = loginRepository.findAll();
        return login;
    }

    public Login gravarLogin(Login login) {
        return loginRepository.save(login);
    } 

    public void deletarLogin(Integer id) {
        loginRepository.deleteById(id);
    }

    public Login updateLogin (Integer id, Login login) {
        Login alterado = findByIdLogin(id);
        if (alterado != null) {
            alterado.setUser(login.getUser());
            alterado.setSenha(login.getSenha());

            return loginRepository.save(alterado);
        }

        return null;
    }
}