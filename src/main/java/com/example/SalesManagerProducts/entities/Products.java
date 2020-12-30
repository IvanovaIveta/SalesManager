package com.example.SalesManagerProducts.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products")
public class Products {
    private Integer product_id;
    private String product_name;
    private String brand;
    private String made_in;
    private float price;
    private int quantity;

    public Products() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getMade_in() {
        return made_in;
    }

    public void setMade_in(String made_in) {
        this.made_in = made_in;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @OneToMany(mappedBy = "product_id")
    private List<Products> products;
}
