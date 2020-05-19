package com.PortalEscuela.Repository;

import com.PortalEscuela.Models.Curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepo extends JpaRepository<Curso,Integer>{
 
}