package Entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "RA")
    int ra;

    @Column (name = "Nome")
    String nome;

    LocalDate dataCadastro;
}
