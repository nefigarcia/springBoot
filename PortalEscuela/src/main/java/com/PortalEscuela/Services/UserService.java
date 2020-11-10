package com.PortalEscuela.Services;

import java.io.IOException;
import java.util.List;

import com.PortalEscuela.Enti.ListActivi;
import com.PortalEscuela.Models.Actividades;
import com.PortalEscuela.Models.Curso;
import com.PortalEscuela.Models.UserModel;
import com.PortalEscuela.Models.UsuCurso;

import org.springframework.web.multipart.MultipartFile;

import com.PortalEscuela.Models.Tarea;


public interface UserService {
public void saveUser(UserModel userModel);
public boolean isUserExist(UserModel userModel);
public void listAll(Object ob,ListActivi curso);
public void saveCurso(Curso curso,String s);
public void saveTarea(Tarea curso);
public void saveidta(Tarea tarea,int idcurso);
public void saveListTar(int idcurso,ListActivi listActivi);
public void saveusercursos(UsuCurso usuCurso,int id_curso,String name);
public UserModel testId(int id,UserModel userModel);
public void saveAct(Actividades actividades,String ema, int act_id, byte[] archivo) ;
}