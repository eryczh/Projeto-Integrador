package com.atividade.Senac.services;

import com.atividade.Senac.Entities.Login;
import com.atividade.Senac.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LoginService {

        @Autowired
        private LoginRepository loginRepository;
        @Bean
        public void instanciarDBLogin() {
            Login login1 = new Login("administrador", "idkdude");
            loginRepository.saveAll(Arrays.asList(login1));
        }
    
}