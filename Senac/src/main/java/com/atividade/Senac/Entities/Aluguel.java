package com.atividade.Senac.Entities;

import java.io.Serializable;

import com.atividade.Senac.services.CPFValidator;

import jakarta.persistence.*;

 @Entity(name = "Alugueis")
public class Aluguel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID_Aluguel")
    int id;

    @Column (name = "Nome_Cliente")
    String nomeCliente;

    @Column (name = "CPF") 
    String cpf;

    @Column (name = "Forma_De_Pagamento")
    String formaDePagamento;

    @ManyToOne
    @JoinColumn(name = "Imovel") 
    private Imovel imovel;
    
    public Aluguel () {
    }

    public Imovel getImovel () {
        return imovel;
    }

    public void setImovel (Imovel imovel) {
        this.imovel = imovel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(!CPFValidator.isValidCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Aluguel(String nomeCliente, String cpf, String formaDePagamento, Imovel imovel) {
        if (!CPFValidator.isValidCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.formaDePagamento = formaDePagamento;
        this.imovel = imovel;
    }

    @Override
    public String toString() {
        return "Alguel {" +
                "id = " + id +
                "nome Cliente = " + nomeCliente +
                "cpf = " + cpf + 
                "forma de pagamento = " + formaDePagamento +
                "}";
    }

}
