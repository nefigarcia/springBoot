package com.PortalEscuela.Models;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import javax.persistence.ManyToMany;


@Entity
@Table(name = "usuarios")
public class UserModel  {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "usu_id")
private int id;

@NotNull(message = "Campo obligatorio")
@Column(name = "nom")
private String nom;

@NotNull(message = "campo obligatorio")
@Email(message = "email is invalid")
@Column(name = "email")
private String email;

@Column(name = "tel")
private int tel;

@NotNull(message="Contrasena obligatoria")
@Length(min = 4, message = "Contrasena min 4 caracters")
@Column(name = "password")
private String password;

@Column(name = "usu")
private String usu;

@Column(name="status")
private String status;

@Column(name = "id_role")
private int id_role;

@Column(name = "id_sep")
private String id_sep;

@Column(name = "escolaridad")
private String  escolaridad;
@Column(name = "grado")
private int grado;

@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(name = "usu_cursos", joinColumns = @JoinColumn(name="id_cursos"), inverseJoinColumns =@JoinColumn(name="usu_id")) 
private Set<Role> roles;

public int getId(){
    return id;
}
public void setId(int id){
    this.id=id;
}
public String getNom(){
    return nom;
}
public void setNom(String nom){
    this.nom=nom;
}
public String getEmail(){
    return email;
}
public void setEmail(String email){
    this.email=email;
}
public String getPassword(){
    return password;
}
public void setPassword(String password){
    this.password=password;
}
public int getTel(){
    return tel;
}
public void setTel(int tel){
    this.tel=tel;
}
public String getUsu(){
    return usu;
}
public void setUsu(String usu){
    this.usu=usu;
}
public String getSta(){
    return status;
}
public void setSta(String sta){
    this.status=sta;
}
public int getIdRole(){
    return id_role;
}
public void setIdRole(int id_role){
    this.id_role=id_role;
}
public void setIdsep(String id_sep){
    this.id_sep=id_sep;
}
public String getIdsep(){
    return id_sep;
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
public Set<Role> getRoles() {
    return roles;
}

public void setRoles(Set<Role> roles) {
    this.roles = roles;
}

}

