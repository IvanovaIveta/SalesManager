package com.example.SalesManagerProducts.service;

import com.example.SalesManagerProducts.entities.Products;
import com.example.SalesManagerProducts.persistence.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository repo;

    public List<Products> listAll() {
        return repo.findAll();
    }

    public void save(Products products) {
        repo.save(products);
    }

    public Products get(Integer product_id) {
        return repo.findById(product_id).get();
    }

    public void delete(Integer product_id) {
        repo.deleteById(product_id);
    }


    public void buy(){

    }
//    public Products createOrUpdateProduct(Products entity) throws Exception {
//        System.out.println("CreateOrUpdateProduct");
//        entity.setProduct_id(entity.getProduct_id());
//        if (entity.getProduct_id() == null) {
//            System.out.println(entity.getProduct_id());
//            entity = repo.save(entity);
//            return entity;
//        } else {
//            Optional<Products> products = repo.findById(entity.getProduct_id());
//
//            if (products.isPresent()) {
//                Products newEntity = products.get();
//                float price = entity.getPrice();
//                newEntity.setPrice(price);
//
//                int newQuantity = entity.getQuantity();
//                if (newQuantity == 0) {
//                    System.out.println("There is no enough quantity");
//                }
//                newEntity.setQuantity(entity.getQuantity());
//                newEntity = repo.save(newEntity);
//
//                return newEntity;
//            } else {
//                entity = repo.save(entity);
//            }
//        }
//        return entity;
//    }
}
