package com.PortalEscuela.Services;

import java.util.List;

import com.PortalEscuela.Enti.ListActivi;
import com.PortalEscuela.Models.Curso;
import com.PortalEscuela.Models.UserModel;
import com.PortalEscuela.Models.Tarea;


public interface UserService {
public void saveUser(UserModel userModel);
public boolean isUserExist(UserModel userModel);
public List<UserModel> listAll(Object ob);
public void saveCurso(Curso curso,String s);
public void saveTarea(Tarea curso);
public void saveidta(Tarea tarea,int idcurso);
public void saveListTar(int idcurso,ListActivi listActivi);
}