package org.example.booksellingweb.service;


import org.example.booksellingweb.dao.RoleDao;
import org.example.booksellingweb.dao.UserDao;
import org.example.booksellingweb.entity.Role;
import org.example.booksellingweb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private RoleDao roleDao;

    @Transactional
    public String register(User user){
        if(userDao.findUserByUsername(user.getUsername()).isPresent()){
            throw new RuntimeException("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<Role> userRole=roleDao.findByRoleName("ROLE_USER");
        if(userRole.isPresent()){
            user.addRole(userRole.get());
            userDao.save(user);
        }
        else{
            Role role=new Role();
            role.setRoleName("ROLE_USER");
            Role roleUser=roleDao.save(role);
            user.addRole(roleUser);
            userDao.save(user);
        }
        return "User registered successfully";
    }
}
