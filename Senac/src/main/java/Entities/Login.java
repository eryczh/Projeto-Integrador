package Entities;

import java.io.Serializable;

import jakarta.persistence.*;
;


/*
 * 
 *     Login
 *     User
 *     Senha
 */
public class Login implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    @Column (name = "User")
    String user;

    @Column (name = "Senha")
    String senha;

    public Login () {

    }

    public String getUser() {
        return user;
    }

    public void setUser (String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Login (String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login {" +
                "user = " + user +
                "senha = " + senha +
                " }";
    }
}
