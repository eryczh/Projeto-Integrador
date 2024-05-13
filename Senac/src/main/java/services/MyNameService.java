package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import Entities.Produto;

@Service
public class MyNameService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    @Bean
    public void instanciarDB() {
        Produto produto1 = new Produto();
        
    }
}
