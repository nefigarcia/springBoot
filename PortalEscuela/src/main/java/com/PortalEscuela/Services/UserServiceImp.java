package com.PortalEscuela.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.io.IOException;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.PortalEscuela.Enti.ListActivi;
import com.PortalEscuela.Models.Actividades;
import com.PortalEscuela.Models.Curso;
import com.PortalEscuela.Models.Role;
import com.PortalEscuela.Models.Tarea;

import com.PortalEscuela.Models.UserModel;
import com.PortalEscuela.Models.UsuCurso;
import com.PortalEscuela.Repository.RoleRepo;
import com.PortalEscuela.Repository.TareaRepo;
import com.PortalEscuela.Repository.UserCursoRepo;
import com.PortalEscuela.Repository.UserRepo;
import com.PortalEscuela.Repository.ActiviRepo;
import com.PortalEscuela.Repository.CursoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;

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
    @Autowired
    UserCursoRepo userCursoRepo;
    @Autowired 
    ActiviRepo activiRepo;

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
        boolean res=true;
        try {
            if(userRepo.findByEmail(userModel.getEmail()).toString()==userModel.getEmail())
        return true;
        } catch(NullPointerException e){
            return res=false;
        }catch (Exception e) {
            return res=true;
        }
        
         return res;
    }
    @Override
    public void listAll(Object ob,ListActivi curso){
        //TypedQuery sqll=em.createQuery("select new Curso(c.id,c.nombre) from Curso c join UsuCurso uc on c.id_usuarios=uc.usu_id join UserModel u on u.id=uc.usu_id where u.email='"+ob+"'",Curso.class);
        TypedQuery sqll=em.createQuery("Select new Curso(cc.id,cc.nombre) from Curso cc where cc.id in (select c.id from Curso c join UserModel u on c.id_usuarios=u.id where u.email='"+ob+"') or cc.id in (Select ccc.id from Curso ccc join UsuCurso uc on ccc.id=uc.id_cursos join UserModel um on uc.usu_id=um.id where um.email='"+ob+"')",Curso.class);
        List<Curso> listAll=sqll.getResultList();     
        TypedQuery sqlgen=em.createQuery("Select new Curso(c.id,c.nombre) from Curso c join UserModel u on c.id_usuarios=u.id where u.id_sep=(select uu.id_sep from UserModel uu where uu.email='"+ob+"')",Curso.class);  
        List<Curso> listgen=sqlgen.getResultList();

        Iterator<Curso> gen=listgen.iterator();
       // Iterator<Curso> us=listAll.iterator();
        /*for (Curso cursos : listAll) {
            int ban=0;
            for (Curso gen : listgen) {
                
                if (gen.getId()==cursos.getId()) {
                  System.out.println("*****"+gen.getId());
                   listgen.remove(0);
                   System.out.println("+++++++++++++++++++++++++");

                }ban++;
            }
        }*/
        while (gen.hasNext()) {
            int ban=0;
            Curso c=gen.next();
            System.out.println(c.getId());
           /* while (us.hasNext()) {
                Curso cu=us.next();
                System.out.println("22222222222 "+ c.getId()+" "+ ++ban);
                cu.getId();
                if (cu.getId()==c.getId()) {
                    gen.remove();;
                    System.out.println("22222222222 "+ c.getId());

                }
            }*/
            for (Iterator<Curso> us=listAll.iterator();us.hasNext();) {
                Curso cu=us.next();
                System.out.println("22222222222 "+ c.getId()+" "+ ++ban);
                cu.getId();
                if (cu.getId()==c.getId()) {
                    gen.remove();;
                    System.out.println("22222222222 "+ c.getId());

                }
            }
        }
        System.out.println("---///////"+listgen);
        curso.setCursosGen(listgen);
        curso.setCursosUsu(listAll);
        
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
        TypedQuery tq=em.createQuery("select new Tarea(id,nombre,instrucciones)  from Tarea where curso_id='"+idcurso+"'",Tarea.class);
        List<Tarea> li=tq.getResultList();
        listActi.setId_curso(idcurso);
        listActi.setListTar(li);
    }
    @Override
    public void saveusercursos(UsuCurso usuCurso, int id_curso, String name){
        TypedQuery tq=em.createQuery("select id from UserModel where email='"+name+"'",Integer.class);
        List<Integer> in=tq.getResultList();
        int iu=in.get(0);
        usuCurso.setId_cursos(id_curso);
        usuCurso.setUsu_id(iu);
        userCursoRepo.save(usuCurso);
    }
    @Override
    public UserModel testId(int id,UserModel userModel){

        if(userModel.getId()==id){
            return userModel;
        }else{
            return null;
        }
    }
    @Override
    public void saveAct(Actividades actividades,String ema, int act_id, byte[] archivo){
        TypedQuery tp=em.createQuery("select id from UserModel where email='"+ema+"'",Integer.class);
        List<Integer> in=tp.getResultList();
        int id=in.get(0);
        actividades.setAct_id(act_id);
        actividades.setUsu_id(id);
        actividades.setArchivo(archivo);
        activiRepo.save(actividades);
    }
    
}