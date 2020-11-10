package com.PortalEscuela.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import javax.persistence.Column;

@Entity
@Table(name = "usu_act")

public class Actividades {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id_act")
 private int id_act;
 @Column(name = "act_id")
 private int act_id;
 @Column(name = "usu_id")
 private int usu_id;
 @Column(name = "archivo")
 @Lob
 @Type(type="org.hibernate.type.BinaryType")
 private byte[] archivo;

 public int getAct_id() {
     return act_id;
 }

 public void setAct_id(int act_id) {
     this.act_id = act_id;
 }

 public int getUsu_id() {
     return usu_id;
 }

 public void setUsu_id(int usu_id) {
     this.usu_id = usu_id;
 }

 
 public int getId_act() {
     return id_act;
 }

 public void setId_act(int id_act) {
     this.id_act = id_act;
 }

 public byte[] getArchivo() {
     return archivo;
 }

 public void setArchivo(byte[] archivo) {
     this.archivo = archivo;
 }

 
}