package com.example.SalesManagerProducts.entities;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @Column(name="roles_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roles_id;
    private String name;

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
