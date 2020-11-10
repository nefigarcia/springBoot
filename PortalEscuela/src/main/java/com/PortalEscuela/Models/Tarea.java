package com.PortalEscuela.Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tareas")
public class Tarea {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "id_tarea")
 private int id;

 public Tarea(int id,String nombre, String instrucciones ){
     this.id=id;
     this.nombre=nombre;
     this.instrucciones=instrucciones;
 }
 public Tarea(){}

 @Column(name = "nombre")
 private String nombre;
 @Column(name = "instrucciones")
 private String instrucciones;
 @Column(name = "curso_id")
 private int curso_id;

 public int getId() {
     return id;
 }

 public void setId(int id) {
     this.id = id;
 }

 public String getNombre() {
     return nombre;
 }

 public void setNombre(String nombre) {
     this.nombre = nombre;
 }

 public String getInstrucciones() {
     return instrucciones;
 }

 public void setInstrucciones(String instrucciones) {
     this.instrucciones = instrucciones;
 }

 public int getCurso_id() {
     return curso_id;
 }

 public void setCurso_id(int curso_id) {
     this.curso_id = curso_id;
 }

 
}