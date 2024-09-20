package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ClientEntity;
import com.example.demo.repositories.ClientRepository;

@Service
public class BankAccountService {

    @Autowired
    ClientRepository clientRepository;


    public void getAllContasById(Long idClient){

        Optional<ClientEntity> optionalClient = clientRepository.findById(idClient);

            if(optionalClient.isPresent()) {
                ClientEntity client = optionalClient.get();
                return client;
            }
            return null;

        

    }
    
}
