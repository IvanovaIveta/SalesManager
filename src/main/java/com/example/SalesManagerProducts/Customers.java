package com.example.SalesManagerProducts;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customers {

        private Integer customer_id;
        private String first_name;
        private String last_name;
        private String town;

        protected Customers(){
            super();
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

}
