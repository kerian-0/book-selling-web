package org.example.booksellingweb.dao;

import org.example.booksellingweb.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(String roleName);
}
