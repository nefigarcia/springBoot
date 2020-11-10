package com.PortalEscuela.Models;

//import java.util.Date;
import java.sql.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_cursos")
private int id;


public Curso(int id, String nombre){
    this.id=id;
    this.nombre=nombre;
}
public Curso(){}

@Column(name = "nombre")
private String nombre;

@Column(name = "id_usuarios")
private int id_usuarios;

@Column(name = "escolaridad")
private String escolaridad;

@Column(name = "grado")
private int grado;

@Column(name = "grupo")
private String grupo;

@Column(name = "periodo")
private Date periodo;

@Column(name = "tarea")
private String tarea;

@Column(name = "examen")
private String examen;



public int getId(){
    return this.id;
}
public void setId(int id){
    this.id=id;
}
public void setNom(String nom){
    this.nombre=nom;
}
public String getNom(){
    return nombre;
}
public int getIdusuario(){
    return id_usuarios;
}
public void setIdusuarios(int id_usuarios){
    this.id_usuarios=id_usuarios;
}
public void setUsuarios(int usuarios){
    this.id_usuarios=usuarios;
}
public int getUsuarios(){
    return id_usuarios;
}
public void setEscolaridad(String escolaridad){
    this.escolaridad=escolaridad;
}
public String getEscolaridad(){
    return escolaridad;
}
public void setGrado(int grado){
    this.grado=grado;
}
public int getGrado(){
    return grado;
}
public void setGrupo(String grupo){
    this.grupo=grupo;
}
public String getGrupo(){
    return grupo;
}
public void setPeriodo(Date date){
    this.periodo=date;
}
public Date getPeriodo(){
    return periodo;
}

public String getTarea() {
    return tarea;
}

public void setTarea(String tarea) {
    this.tarea = tarea;
}

public String getExamen() {
    return examen;
}

public void setExamen(String examen) {
    this.examen = examen;
}





}
