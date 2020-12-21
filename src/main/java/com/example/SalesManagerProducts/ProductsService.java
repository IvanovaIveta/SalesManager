package com.example.SalesManagerProducts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository repo;

    public List<Products> listAll(){
        return repo.findAll();
    }

    public void save(Products products){
        repo.save(products);
    }

    public Products get(Integer product_id){
        return repo.findById(product_id).get();
    }

    public void delete(Integer product_id){
        repo.deleteById(product_id);
    }
}
