package com.example.SalesManagerProducts.entities;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customers {

        private Integer customer_id;
        private String first_name;
        private String last_name;
        private String town;
        private String phonenumber;

        public Customers(){
            super();
        }

    public Customers(Integer customer_id, String first_name, String last_name, String town, String phonenumber) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.town = town;
        this.phonenumber = phonenumber;
    }

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Integer getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(Integer customer_id) {
            this.customer_id = customer_id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getTown() {
            return town;
        }

        public void setTown(String town) {
            this.town = town;
        }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
