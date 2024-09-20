package com.example.demo.repositories;

import com.example.demo.entities.ClientEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "conta-bancaria")
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id_conta")
    private Long id;

    @Column(name = "numero_conta")
    private String AccountNumber;

    @Column(name = "agencia")
    private String agency;

    @Column(name = "tipo")
    private String type;

    @Column(name = "saldo")
    private Float balance;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClientEntity client;






    
}
