package com.atividade.Senac.Entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity(name = "Login")
public class Login implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID_User")
    int id;
    
    @Column (name = "User")
    String user;

    @Column (name = "Senha")
    String senha;

    public Login () {
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id = " + id +
                ", user = " + user +
                ", senha = " + senha +
                "}";
    }
}
