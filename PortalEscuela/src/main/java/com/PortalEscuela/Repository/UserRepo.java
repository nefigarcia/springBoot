package com.PortalEscuela.Repository;

import com.PortalEscuela.Models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer>{
   public UserModel findByEmail(String email) ;
}