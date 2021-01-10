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
    private Integer saleId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date")
//    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date dateSold;

    @Column(name = "quantity_sold", nullable = false)
    private Integer quantity_sold;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", referencedColumnName = "product_id")
//   private Products product;
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Customers buyer;

    @ManyToOne
    private Users salesRepresentative;

    public Sale() {

    }

    public Sale(Integer saleId, Date dateSold, Integer quantitySold, Integer productId, Customers buyer, Users salesRepresentative) {
        this.saleId = saleId;
        this.dateSold = dateSold;
        this.quantitySold = quantitySold;
        this.productId= productId;
        this.buyer = buyer;
        this.salesRepresentative = salesRepresentative;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Date getDateSold() {
        return dateSold;
    }

    public void setDateSold(Date dateSold) {
        this.dateSold = dateSold;
    }

    public Integer getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Integer quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    //    public Products getProduct() {
//        return product;
//    }
//
//    public void setProduct(Products product) {
//        this.product = product;
//    }

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

}

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Integer getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Integer quantitySold) {
        this.quantitySold = quantitySold;
    }
}
//package com.example.SalesManagerProducts.entities;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.util.Date;
//
//@Entity
//@Table(name="sale")
//public class Sale implements Serializable {
//
//    private Integer saleId;
//    private LocalDate date;
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
//    public Sale(Integer saleId, LocalDate date, Products productId, Integer quantityProduct, Users user_id) {
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
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
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


//       @Entity
//       @Table(name="sale")
//       public class Sale {
//       @Id
//       @GeneratedValue(strategy = GenerationType.IDENTITY)
//       private Integer saleId;
//
//       @JsonFormat(pattern = "dd/MM/yy")
//       private LocalDate date;
//
//       @JsonManagedReference
//       @OneToMany(mappedBy = "saleId")
//       @Valid
//       private List<SaleProduct> saleProducts = new ArrayList<>();
//
//       @Transient
//       public Double getTotalSalePrice() {
//              double sum = 0D;
//              List<SaleProduct> saleProducts = getSaleProducts();
//              for (SaleProduct sp : saleProducts) {
//                     sum += sp.getTotalPrice();
//              }
//              return sum;
//       }
//
//       @Transient
//       public int getNumberOfProducts(){
//              return this.saleProducts.size();
//       }
//
//       public Integer getSaleId() {
//              return saleId;
//       }
//
//       public void setSaleId(Integer saleId) {
//              this.saleId = saleId;
//       }
//
//       public LocalDate getDate() {
//              return date;
//       }
//
//       public void setDate(LocalDate date) {
//              this.date = date;
//       }
//
//       public List<SaleProduct> getSaleProducts() {
//              return saleProducts;
//       }
//
//       public void setSaleProducts(List<SaleProduct> saleProducts) {
//              this.saleProducts = saleProducts;
//       }
//}
