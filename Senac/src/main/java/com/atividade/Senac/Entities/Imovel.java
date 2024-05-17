package com.atividade.Senac.Entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity(name = "Imoveis")
public class Imovel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID_Imovel")
    int id;

    @Column (name = "Nome")
    String nome;

    @Column (name = "Cidade")
    String cidade;

    @Column (name = "Endereço")
    String endereco;

    @Column (name = "CEP")
    String cep;

    @Column (name = "Número")
    int numero;

    @Column (name = "Tipo")
    String tipo;

    @Column (name = "Valor")
    Double valor;

    @Column (name = "Alugada")
    boolean alugada;

    public Imovel () {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return cidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCEP() {
        return cep;
    }

    public void setCEP(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getAlugada() {
        return alugada;
    }

    public void setAlugada(boolean alugada) {
       this.alugada = alugada;
    }

    public Imovel(String nome, String cidade, String endereco, String cep, int numero, String tipo, double valor, boolean alugada) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
        this.cep = cep;
        this.numero = numero;
        this.tipo = tipo;
        this.valor = valor;
        this.alugada = alugada;
    }

    @Override
    public String toString() {
        return "Imovel {" +
                "id = " + id +
                ", nome = " + nome +
                ", cidade = " + cidade +
                ", endereco = " + endereco +
                ", cep = " + cep +
                ", numero = " + numero +
                ", tipo = " + tipo +
                ", valor = " + valor +
                ", alugada = " + alugada +
                "}";
    }
}
