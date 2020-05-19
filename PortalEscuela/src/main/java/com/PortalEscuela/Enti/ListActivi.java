package com.PortalEscuela.Enti;
import java.util.List;

import org.springframework.context.annotation.Bean;


public class ListActivi {
    
    
    private int id_curso;
    private List<Integer> listTar;

    public List<Integer> getListTar() {
        return listTar;
    }

    public void setListTar(List<Integer> listTar) {
        this.listTar = listTar;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

}