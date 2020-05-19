package com.giftsIntercambio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_USUARIOS")
public class UsuEntity{
    private String nombre,nombre2;
public UsuEntity(){}
    public UsuEntity(String a,String b){
        nombre=a;nombre2=b;
    }

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name="nombre")

public Long getId(){
    return id;
}
public void setId(Long id){
    this.id=id;
}

public String getNombre(){
    return nombre;
}
public void setNombre(String nombre){
 this.nombre=nombre;
}
public String getNombre2(){
    return nombre2;
}
public void setNombre2(String nombre){
 this.nombre2=nombre;
}
@Override
public String toString(){
    return "Usuario[id"+id+",nombre"+nombre+"]";
}
}