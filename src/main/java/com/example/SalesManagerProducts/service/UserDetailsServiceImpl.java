package com.example.SalesManagerProducts.service;

import com.example.SalesManagerProducts.MyUserDetails;
import com.example.SalesManagerProducts.entities.Role;
import com.example.SalesManagerProducts.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    public List<Users> listAll(){
        return (List<Users>) userRepo.findAll();
    }
    public List<Users> loadUserByRole(){
        return (List<Users>) userRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.getUserByUsername(username);

       Set<GrantedAuthority>grantedAuthorities = new HashSet<>();
       for(Role role:user.getRoles()){
           grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
       }
        if(user == null){
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUserDetails(user);
      // return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
