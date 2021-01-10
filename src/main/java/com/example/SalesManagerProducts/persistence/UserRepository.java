package com.example.SalesManagerProducts.persistence;

import com.example.SalesManagerProducts.entities.Users;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query("SELECT u FROM Users u WHERE u.username= :username")
    public Users getUserByUsername(@Param("username") String username);

//    @Query("SELECT u FROM Users u JOIN u.roles as r WHERE r.roles_id=2")
//    public List<Users> getSalesRepresentatives();

    @Query("SELECT u FROM Users u JOIN u.roles as r WHERE r.name=:name")
    public List<Users> getUsersByRole(@Param("name")String name);

}


//
}

