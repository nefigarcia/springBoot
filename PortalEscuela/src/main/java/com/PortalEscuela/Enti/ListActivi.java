package com.PortalEscuela.Enti;
import java.util.List;
import com.PortalEscuela.Models.Curso;
import com.PortalEscuela.Models.Tarea;


public class ListActivi {
    
    
    private int id_curso;
    private List<Tarea> listTar;
    private List<Curso> listCur;
    
    private List<Curso> cursosGen;
    private List<Curso> cursosUsu;
    public List<Tarea> getListTar() {
        return listTar;
    }

    public void setListTar(List<Tarea> listTar) {
        this.listTar = listTar;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public List<Curso> getListCur() {
        return listCur;
    }

    public void setListCur(List<Curso> listCur) {
        this.listCur = listCur;
    }
    public List<Curso> getCursosGen() {
        return cursosGen;
    }
    
    public void setCursosGen(List<Curso> cursosGen) {
        this.cursosGen = cursosGen;
    }
    
    public List<Curso> getCursosUsu() {
        return cursosUsu;
    }
    
    public void setCursosUsu(List<Curso> cursosUsu) {
        this.cursosUsu = cursosUsu;
    }
    

}