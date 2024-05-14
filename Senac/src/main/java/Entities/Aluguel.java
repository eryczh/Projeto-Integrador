package Entities;

import java.io.Serializable;

import jakarta.persistence.*;

/* 
 * Aluguel
 * ****************** *
 * Nome do Cliente    *
 * CPF                *
 * Forma de Pagamento *
 * ID imovel alugado  *
 *  ***************** *
 */

 @Entity
public class Aluguel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    int id;

    @Column (name = "Nome_Cliente")
    String nomeCliente;

    @Column (name = "CPF") 
    String cpf;

    @Column (name = "Forma_De_Pagamento")
    String formaDePagamento;

    public Aluguel () {

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
        return nomeCliente;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Aluguel(String nomeCliente, String cpf, String formaDePagamento) {
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.formaDePagamento = formaDePagamento;
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
