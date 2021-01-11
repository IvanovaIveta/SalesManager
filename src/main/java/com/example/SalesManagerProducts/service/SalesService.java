package com.example.SalesManagerProducts.service;

import com.example.SalesManagerProducts.MyUserDetails;
import com.example.SalesManagerProducts.entities.Products;
import com.example.SalesManagerProducts.entities.Sale;
import com.example.SalesManagerProducts.persistence.SalesRepository;
import com.example.SalesManagerProducts.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepo;


    private static String getUsername(){
        SecurityContext securityContext= SecurityContextHolder.getContext();
        Authentication authentication= securityContext.getAuthentication();
        String username=null;
        if(authentication!=null){
            MyUserDetails myUserDetails= (MyUserDetails) authentication.getPrincipal();
            username= myUserDetails.getUsername();
        }
        return username;
    }
    Products product = new Products();

    public List<Sale> listAll(){
        return salesRepo.findAll();
    }

//    public void save(Sale sale){
//        salesRepo.save(sale);
//    }

    public void save(Sale sale){
        Sale sale1=new Sale(sale.getSale_id(),sale.getDateSold(),sale.getQuantity_sold(),sale.getProduct(),sale.getBuyer(),getUsername());
        salesRepo.save(sale1);
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
