package com.example.demo.dtos.res;

import java.util.List;

public class BankAccountsByClientRes {

    private String name;
    private List<String> numbers;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getNumbers() {
        return numbers;
    }
    public void setNumbers(List <String> numbers) {
        this.numbers = numbers;
    }
    
}
