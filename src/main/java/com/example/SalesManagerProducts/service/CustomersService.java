package com.example.SalesManagerProducts.service;

import com.example.SalesManagerProducts.entities.Customers;
import com.example.SalesManagerProducts.persistence.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository repo;

    public List<Customers> listAll() {
        return repo.findAll();
    }

    public void save(Customers customers) {
        repo.save(customers);
    }

    public Customers get(Integer customer_id){
        return repo.findById(customer_id).get();
    }

    public void delete(Integer customer_id){
            repo.deleteById(customer_id);
    }
}
