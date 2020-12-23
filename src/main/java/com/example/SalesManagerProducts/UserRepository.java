package com.example.SalesManagerProducts;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer>, JpaRepository<Users, Integer>{

    @Query("SELECT u FROM Users u WHERE u.username= :username")
    public Users getUserByUsername(@Param("username") String username);
}
