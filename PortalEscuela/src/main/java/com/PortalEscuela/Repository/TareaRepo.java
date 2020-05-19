package com.PortalEscuela.Repository;

import com.PortalEscuela.Models.Tarea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepo extends JpaRepository<Tarea,Integer>{

}