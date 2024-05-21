package com.atividade.Senac.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.Senac.Entities.Login;
import com.atividade.Senac.Repository.LoginRepository;

@Service
public class DBSeviceLogin {
    
    @Autowired
    private LoginRepository loginRepository;

    public Login findByIdLogin(Integer id) {
        Optional<Login> login = loginRepository.findById(id);
        return login.orElse(null);
    }

    public List<Login> listarOsLogins() {
        List<Login> login = loginRepository.findAll();
        return login;
    }

    public Login  gravarLogin(Login login) {
        return loginRepository.save(login);
    }

    public void deletarLogin (Integer id) {
        loginRepository.deleteById(id);
    }

    public Login updateLogin (Integer id, String user, String senha) {
        Login alterado = findByIdLogin(id);

        if (alterado != null) {
            alterado.setId(alterado.getId());
            alterado.setUser(alterado.getUser());
            alterado.setSenha(alterado.getSenha());

            return loginRepository.save(alterado);
        }

        return null;
    }
    
    public Login validarLogin(String user, String senha) {
        return loginRepository.findByUserAndSenha(user, senha);
    }
    
    public Login buscarLogin(String user, String senha) {
        return loginRepository.findByUserAndSenha(user, senha);
    }
}
