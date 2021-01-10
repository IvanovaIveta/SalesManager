package com.example.SalesManagerProducts;

import com.example.SalesManagerProducts.entities.Role;
import com.example.SalesManagerProducts.entities.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class MyUserDetails implements UserDetails {

    private Users user;

    public MyUserDetails(Users user) {
        this.user = user;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles= user.getRoles();
        List<SimpleGrantedAuthority> authorities= new ArrayList<>();

        // Set<GrantedAuthority>grantedAuthorities= new HashSet<>();
        for(Role role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
   


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
       return true;
    }
}

