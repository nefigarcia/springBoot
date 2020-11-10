package com.PortalEscuela.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usu_cursos")
public class UsuCurso {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usucursos")
    private int id;

    @Column(name = "id_cursos")
    private int id_cursos;

    @Column(name = "usu_id")
    private int usu_id;

    public int getId_cursos() {
        return id_cursos;
    }

    public void setId_cursos(int id_cursos) {
        this.id_cursos = id_cursos;
    }

    public int getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}