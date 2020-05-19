package com.PortalEscuela.Services;

import java.time.LocalDate;
import java.util.Arrays;
//import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.PortalEscuela.Enti.ListActivi;
import com.PortalEscuela.Models.Curso;
import com.PortalEscuela.Models.Role;
import com.PortalEscuela.Models.Tarea;

import com.PortalEscuela.Models.UserModel;
import com.PortalEscuela.Repository.RoleRepo;
import com.PortalEscuela.Repository.TareaRepo;
import com.PortalEscuela.Repository.UserRepo;
import com.PortalEscuela.Repository.CursoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService{

    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    CursoRepo cursoRepo;
    @Autowired 
    TareaRepo tareaRepo;

    @Override
    public void saveUser(UserModel userModel){
        userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        userModel.setSta("verified");
        Role useRole=roleRepo.findByRole("normal");
        userModel.setRoles(new HashSet<Role>(Arrays.asList(useRole)));
        userRepo.save(userModel);
    }
    @Override
    public boolean isUserExist(UserModel userModel){
        return false;
    }
    @Override
    public List<UserModel> listAll(Object ob){
        TypedQuery sqll=em.createQuery("select c.id from Curso c join UsuCurso uc on c.id_usuarios=uc.usu_id join UserModel u on u.id=uc.usu_id where u.email='"+ob+"'",Integer.class);
      List<UserModel> listAll=sqll.getResultList();
      return listAll;
    }
    @Override
    public void saveCurso(Curso curso,String s){
        LocalDate date = LocalDate.now();
        Date da=java.sql.Date.valueOf(date);
      TypedQuery sql=em.createQuery("Select id from UserModel where email='"+s+"'",Integer.class);
      int i=(int)(sql.getSingleResult());
      curso.setIdusuarios(i);
      curso.setPeriodo(da);
      cursoRepo.save(curso);
    }
    @Override
    public void saveTarea(Tarea tarea){
       
        tareaRepo.save(tarea);
    }
    @Override
    public void saveidta(Tarea tarea,int idcurso){
        tarea.setCurso_id(idcurso);
    }
    @Override
    public void saveListTar(int idcurso,ListActivi listActi){
        TypedQuery tq=em.createQuery("select id from Tarea where curso_id='"+idcurso+"'",Integer.class);
        List<Integer> li=tq.getResultList();
        listActi.setId_curso(idcurso);
        listActi.setListTar(li);
    }
    
}