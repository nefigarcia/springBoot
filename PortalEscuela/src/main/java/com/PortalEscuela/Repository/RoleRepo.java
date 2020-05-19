package com.PortalEscuela.Repository;

import com.PortalEscuela.Models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer>{
    public Role findByRole(String role);

}