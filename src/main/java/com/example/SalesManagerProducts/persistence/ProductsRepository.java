package com.example.SalesManagerProducts.persistence;

import com.example.SalesManagerProducts.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
