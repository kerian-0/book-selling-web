package org.example.booksellingweb.dao;


import org.example.booksellingweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Long> {

    Optional<User> findUserByUsername(String username);
}
