package com.example.SalesManagerProducts.persistence;

import com.example.SalesManagerProducts.entities.Role;
import com.example.SalesManagerProducts.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<com.example.SalesManagerProducts.entities.Role, Integer> {

    Role findByName(String role);
}
