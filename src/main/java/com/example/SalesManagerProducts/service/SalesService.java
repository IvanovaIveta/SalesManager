package com.example.SalesManagerProducts.service;

import com.example.SalesManagerProducts.MyUserDetails;
import com.example.SalesManagerProducts.entities.Products;
import com.example.SalesManagerProducts.entities.Sale;
import com.example.SalesManagerProducts.persistence.ProductsRepository;
import com.example.SalesManagerProducts.persistence.SalesRepository;
import com.example.SalesManagerProducts.persistence.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Order;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class SalesService {

    @Autowired
    private SalesRepository salesRepo;

    @Autowired
    private ProductsRepository productsRepo;


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

//    public List<Sale> listAll(){
//        return salesRepo.findAll();
//    }

    public List<Sale> listAll(String keyword){
        if(keyword!=null) {
            return salesRepo.findAll(keyword);
        }else {
            return salesRepo.findAll();
        }
    }

//    public void save(Sale sale){
//        salesRepo.save(sale);
//    }

//    Date date= new Date(System.currentTimeMillis());

    public void save(Sale sale) throws Exception {
        Sale sale1=new Sale(sale.getSale_id(),sale.getDateSold(),sale.getQuantity_sold(),sale.getProduct(),sale.getBuyer(),getUsername());
        salesRepo.save(sale1);
//        decreaseAmount(product.getQuantity(),sale.getQuantity_sold());
    }

//    @Autowired
//    private ObjectMapper saleMapper;
//
//    public Sale save(Sale sale) throws Exception {
//        Optional<Products> purchased=productsRepo.findById(sale.getProduct().getProduct_id());
//        Sale sale1=saleMapper.INSTANCE.toEntity(sale);
//        Objects.requireNonNull(purchased,"You cannot buy a non existing product");
//
//        sale.setProduct(purchased.get());
//        purchased.get().setQuantity(purchased.get().getQuantity()-sale.getQuantity_sold());
//
//        sale=salesRepo.save(sale1);
//        productsRepo.save(purchased.get());
//
//        return saleMapper.INSTANCE.toDto(sale1);
//    }


    public Sale get(Integer saleId){
         return salesRepo.findById(saleId).get();
    }

    public void delete(Integer saleId){
        salesRepo.deleteById(saleId);
    }

//    public void decreaseAmount(Integer quantity, Integer quantitySold) throws Exception {
//        if(quantity>quantitySold){
//            quantity=quantity-quantitySold;
//        }else throw new Exception("There is not enough in stock.Sorry.");
//    }


}
