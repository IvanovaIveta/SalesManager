package com.example.SalesManagerProducts.entities;

//
//import org.springframework.security.core.userdetails.User;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sale_id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date")
//    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date dateSold;

    @Column(name = "quantity_sold")
    private Integer quantity_sold;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product", referencedColumnName = "product_id")
//   private Products product;
    private Products product;

    @ManyToOne
    @JoinColumn(name = "client")
    private Customers buyer;

    @ManyToOne
    @JoinColumn(name="sales_representative_id")
    private Users salesRepresentative;

    public Sale() {

    }

    public Sale(Integer sale_id, Date dateSold, Integer quantity_sold, Products product, Customers buyer, Users salesRepresentative) {
        this.sale_id = sale_id;
        this.dateSold = dateSold;
        this.quantity_sold = quantity_sold;
        this.product = product;
        this.buyer = buyer;
        this.salesRepresentative = salesRepresentative;
    }

    public Integer getSale_id() {
        return sale_id;
    }

    public void setSale_id(Integer sale_id) {
        this.sale_id = sale_id;
    }

    public Date getDateSold() {
        return dateSold;
    }

    public void setDateSold(Date dateSold) {
        this.dateSold = dateSold;
    }

    public Integer getQuantity_sold() {
        return quantity_sold;
    }

    public void setQuantity_sold(Integer quantity_sold) {
        this.quantity_sold = quantity_sold;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Customers getBuyer() {
        return buyer;
    }

    public void setBuyer(Customers buyer) {
        this.buyer = buyer;
    }

    public Users getSalesRepresentative() {
        return salesRepresentative;
    }

    public void setSalesRepresentative(Users salesRepresentative) {
        this.salesRepresentative = salesRepresentative;
    }
    //    public Products getProduct() {
//        return product;
//    }
//
//    public void setProduct(Products product) {
//        this.product = product;
//    }



}
