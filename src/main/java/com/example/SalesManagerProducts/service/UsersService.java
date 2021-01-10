package com.example.SalesManagerProducts.service;


import com.example.SalesManagerProducts.entities.Role;
import com.example.SalesManagerProducts.entities.Users;
import com.example.SalesManagerProducts.persistence.RoleRepository;
import com.example.SalesManagerProducts.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UsersService extends UserDetailsServiceImpl {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleRepository roleRepository;



    public void save(Users users){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String encodedPassword= encoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        Role role= roleRepository.findByName("SalesRepresentative" );
        users.getRoles().add(role);
        users.setEnabled(true);
        repo.save(users);
    }

    public Users get(Integer user_id){
        return repo.findById(user_id).get();
    }
    public void delete(Integer user_id){
        repo.deleteById(user_id);
    }


    public List<Users> getRepresentatives(){
        return repo.getUsersByRole("SalesRepresentative");
    }


}
