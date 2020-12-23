package com.example.SalesManagerProducts.service;

import com.example.SalesManagerProducts.Users;
import com.example.SalesManagerProducts.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UserRepository repo;

    public List<Users> listAll(){
        return repo.findAll();
    }
    public void save(Users users){
        repo.save(users);
    }
    public Users get(Integer user_id){
        return repo.findById(user_id).get();
    }
    public void delete(Integer user_id){
        repo.deleteById(user_id);
    }
}
