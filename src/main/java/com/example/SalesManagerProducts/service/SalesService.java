package com.example.SalesManagerProducts.service;

import com.example.SalesManagerProducts.entities.Products;
import com.example.SalesManagerProducts.entities.Sale;
import com.example.SalesManagerProducts.persistence.SalesRepository;
import com.example.SalesManagerProducts.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepo;



    Products product = new Products();

    public List<Sale> listAll(){
        return salesRepo.findAll();
    }

    public void save(Sale sale){
        salesRepo.save(sale);
    }

    public Sale get(Integer saleId){
         return salesRepo.findById(saleId).get();
    }

    public void delete(Integer saleId){
        salesRepo.deleteById(saleId);
    }

    public void decreaseAmount(Integer quantity, Integer quantitySold) throws Exception {
        if(quantity>quantitySold){
            quantity=quantity-quantitySold;
        }else throw new Exception("There is not enough in stock.Sorry.");
    }


}
