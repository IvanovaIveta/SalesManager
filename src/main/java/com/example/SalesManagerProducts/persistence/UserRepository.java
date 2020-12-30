package com.example.SalesManagerProducts.persistence;

import com.example.SalesManagerProducts.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer>, JpaRepository<Users, Integer> {

  //  Object Role = ;

    @Query("SELECT u FROM Users u WHERE u.username= :username")
    public Users getUserByUsername(@Param("username") String username);

   @Query("SELECT u FROM Users u JOIN u.roles as r WHERE r.roles_id=2")
//    @Query("SELECT * FROM salesdb.users_roles WHERE roles_id=2")
    public List<Users> getUsersByRoles();

//   @Query("SELECT u FROM Users as u join u.roles as r WHERE r.roles_id=?1 AND u.enabled")
//           public List<User> findByRoles(@Param("roles_id") List<String> roles);
////    @Query("SELECT u FROM Users as u JOIN u.roles as r WHERE r.roles_id=?1 AND u.enabled= true")
////   // @Query("SELECT u FROM Users as u JOIN u.roles as r WHERE r.roles_id = ?1 AND u.enabled= true")
//////   @Query( "SELECT u FROM Users u inner join u.roles r where r.roles_id in :roles_id" )
// public Users findUserByRole(@Param("roles_id") Integer roles_id);
////   // public Users findUserByRole(Integer roles_id);
//// //   public List<Users> findUserByRole(int roleID);
////
//////    @Query("SELECT * FROM salesdb.users_roles where roles_id: roles_id")
//////    public Users findUsersByRoles(@Pa)


//
}

