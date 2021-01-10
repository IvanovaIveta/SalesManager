package com.example.SalesManagerProducts.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(name="username", nullable = false)
    private String username;
    private String name;
  private String surname;

    @Column(name="password",nullable=false, length = 64)
    private String password;

    @Column(name="enabled")
    private boolean enabled;
    //   private boolean admin;

    public Users(){
        super();
    }
    @ManyToMany(cascade= CascadeType.ALL, fetch =FetchType.EAGER , targetEntity = Role.class)
    @JoinTable(
            name="users_roles",
            joinColumns= @JoinColumn(name="user_id", referencedColumnName="user_id"),
            inverseJoinColumns = @JoinColumn(name= "role_id", referencedColumnName="roles_id")
    )
   private Set<Role> roles = new HashSet<>();





    public Users(Integer user_id, String username, String name, String password, boolean enabled, Set<Role> roles) {
        this.user_id = user_id;
        this.username = username;
        this.name=name;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }



//    public <T> Users(String name, String surname, String surname1, String username, String password, List<T> asList) {
//    }

//    public <T> Users(String firstName, String lastName, String password, List<T> asList) {
//    }
//
//    public Users(){
//
//    }
//private Collection<Role> roles;

    public Integer getId() {
        return user_id;
    }

    public void setId(Integer user_id) {
        this.user_id = user_id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    public Integer getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(Integer user_id) {
//        this.user_id = user_id;
//    }

//    @OneToMany(mappedBy = "sales_representative_id")
//    private List<Sale> sales;
//
//    public List<Sale> getSales() {
//        return sales;
//    }
//
//    public void setSales(List<Sale> sales) {
//        this.sales = sales;
//    }

}
