package com.atividade.Senac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OlaMundo {

    @RequestMapping("/") // a fim de mapear a raiz do servidor
    @ResponseBody // a fim de imprimir no corpo da página
    public String Ola() {
        return "Aplicação Funcionando!";
    }
}
