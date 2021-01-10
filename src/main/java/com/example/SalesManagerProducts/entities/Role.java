package com.example.SalesManagerProducts.entities;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @Column(name="roles_id", nullable=false, unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roles_id;

    @Column(name="name")
    private String name;

//
//    public Role() {
//       super();
//    }

    @ManyToMany(mappedBy="roles")
    private List<Users> users;

    public Role(Integer roles_id) {
        super();
        this.roles_id = roles_id;
    }
    public Role(){

    }

    public Integer getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(Integer roles_id) {
        this.roles_id = roles_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
