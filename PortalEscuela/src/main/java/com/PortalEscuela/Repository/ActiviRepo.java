package com.PortalEscuela.Repository;

import com.PortalEscuela.Models.Actividades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviRepo extends JpaRepository<Actividades,Integer> {

}