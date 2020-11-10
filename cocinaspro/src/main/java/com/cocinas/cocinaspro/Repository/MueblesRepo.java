package com.cocinas.cocinaspro.Repository;

import com.cocinas.cocinaspro.Models.Muebles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 @Repository
public interface MueblesRepo extends JpaRepository<Muebles,Integer>{
    
}