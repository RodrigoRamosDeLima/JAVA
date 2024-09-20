package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.res.BankAccountsByClientRes;
import com.example.demo.entities.ClientEntity;
import com.example.demo.services.BankAccountService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping("clients/{id}/conta-bancaria")
    public ResponseEntity<?>getAllContas(@PathParam(value="id")Long idClient){

        ClientEntity entity = bankAccountService.getAllContasById(idClient);

        BankAccountsByClientRes dto= new BankAccountsByClientRes();
        dto.setName(entity.getName());

        List<String> numbers = entity.getBankAccount()
        .stream() 
        .map(account -> account.getNumbers())
        .toList();


        dto.setNumbers(null);





        return ResponseEntity.status(200).body(dto);
    }
    
        
    
}
