package com.example.demo.entities;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.repositories.BankAccountEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id")
    private Long id;

    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "nome")
    private String name;
    
    @Column(name = "celular")
    private String phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "data_nascimento")
    private LocalDate birthDate;
    
    @OneToMany(mappedBy = "client") // sempre que tiver mappedby vai puxar a variavel do java
    private 
   List<BankAccountEntity> bankAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<BankAccountEntity> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<BankAccountEntity> bankAccount) {
        this.bankAccount = bankAccount;
    }

   
}


