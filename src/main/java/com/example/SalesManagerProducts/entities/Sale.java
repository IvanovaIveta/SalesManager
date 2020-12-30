package com.example.SalesManagerProducts.entities;
//
//import org.springframework.security.core.userdetails.User;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name="sale")
//public class Sale {
//
//    private Integer saleId;
//    private Date date;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Products productId;
//
//    private Integer quantityProduct;
//
//    @ManyToOne
//    @JoinColumn(name="sales_representative_id")
//    private Users user_id;
//
//    public Sale(Integer saleId, Date date, Products productId, Integer quantityProduct, Users user_id) {
//        this.saleId = saleId;
//        this.date = date;
//        this.productId = productId;
//        this.quantityProduct = quantityProduct;
//        this.user_id = user_id;
//    }
//
//    public Sale() {
//
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public Integer getSaleId() {
//        return saleId;
//    }
//
//    public void setSaleId(Integer saleId) {
//        this.saleId = saleId;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Products getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Products productId) {
//        this.productId = productId;
//    }
//
//    public Integer getQuantityProduct() {
//        return quantityProduct;
//    }
//
//    public void setQuantityProduct(Integer quantityProduct) {
//        this.quantityProduct = quantityProduct;
//    }
//
//    public Users getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(Users user_id) {
//        this.user_id = user_id;
//    }
//}
       public class Sale {

       }