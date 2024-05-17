package com.atividade.Senac.Entities;

import java.io.Serializable;

import jakarta.persistence.*;


@Entity
public class Login implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "Id_User")
    int id;

    @Column(name = "user_name")
    String user;

    @Column (name = "senha")
    String senha;

    public Login () {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
       return id; 
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Login(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login {" +
            "id = " + id + 
            ", user = " + user +
            ", senha = " + senha +
            " } ";   
    }

}
