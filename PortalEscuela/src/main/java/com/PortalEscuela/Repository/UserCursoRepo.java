package com.PortalEscuela.Repository;

import com.PortalEscuela.Models.UsuCurso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCursoRepo extends JpaRepository<UsuCurso,Integer>{
 
}