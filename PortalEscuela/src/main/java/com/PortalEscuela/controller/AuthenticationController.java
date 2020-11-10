package com.PortalEscuela.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.PortalEscuela.Enti.ListActivi;
import com.PortalEscuela.Models.Actividades;
import com.PortalEscuela.Models.Curso;
import com.PortalEscuela.Models.Tarea;
import com.PortalEscuela.Models.UserModel;
import com.PortalEscuela.Models.UsuCurso;
import com.PortalEscuela.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AuthenticationController {
    @Autowired
    UserService userService;
    

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public ModelAndView inicio(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("inicio");
        return modelAndView;
    }
    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public ModelAndView logi(UserModel userModel){
        ModelAndView modelAndView=new ModelAndView();
        //AuthenticateAction au=(AuthenticateAction) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//System.out.println(au);
        modelAndView.setViewName("login");
        return modelAndView; 
    }
    @RequestMapping(value="/home", method= RequestMethod.GET)
    public ModelAndView home(){
       String s =SecurityContextHolder.getContext().getAuthentication().getName();
       ListActivi curso=new ListActivi();
        userService.listAll(s,curso);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("userModel", curso);
        modelAndView.setViewName("home");
        return modelAndView;
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register(Model model){
        UserModel userModel=new UserModel();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("userModel", userModel);
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerMethod(@Valid UserModel userModel,BindingResult bindingResult,ModelMap modelMap){
        ModelAndView modelAndView=new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("successMessage", "Revisa forma");
            modelMap.addAttribute("bindingResult",bindingResult);
        }else if(userService.isUserExist(userModel)){
            modelAndView.addObject("successMessage", "User already exist!!");
        }else{
            userService.saveUser(userModel);
            modelAndView.addObject("successMessage", "Usuario Registrado");
        }
        modelAndView.addObject("userModel", new UserModel());
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @RequestMapping(value = "/curso",method=RequestMethod.GET)
    public ModelAndView curs(){
        LocalDate lo=LocalDate.now();
        ModelAndView modelAndView=new ModelAndView();
        Curso curso=new Curso();
        modelAndView.addObject("curso", curso);
        return modelAndView;
    }

    @RequestMapping(value = "/curso",method = RequestMethod.POST)
    public ModelAndView registrarcurso(@Valid Curso curso){
        String s =SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(s);
        ModelAndView modelAndView= new ModelAndView();
       
        userService.saveCurso(curso,s);
       // modelAndView.addObject("curso", curso);
        return modelAndView;
    }
    @RequestMapping(value = "/cursoDetail",method = RequestMethod.GET)
    public ModelAndView cursoDetail(@RequestParam(value = "idcurso")Integer idcurso){
        ModelAndView modelAndView=new ModelAndView();
        Tarea tarea=new Tarea(); 
        ListActivi listActivi=new ListActivi();
        userService.saveListTar(idcurso,listActivi);
        userService.saveidta(tarea,idcurso);
        modelAndView.addObject("nuetarea", tarea);
        return modelAndView;
    }
    @RequestMapping(value = "/cursoDetail",method = RequestMethod.POST)
    public String tareNueva(@Valid Tarea tarea){
        ModelAndView modelAndView=new ModelAndView();
        userService.saveTarea(tarea);
        int idcursos=tarea.getCurso_id();
       modelAndView.addObject("nuetarea", tarea);
        return "redirect:/listActivi?idcurso="+idcursos+"";
    }
    
    @RequestMapping(value = "/listActivi",method = RequestMethod.GET)
    public ModelAndView listAct(@RequestParam(value = "idcurso")Integer idcurso){
        ModelAndView modelAndView=new ModelAndView();
        ListActivi listActivi=new ListActivi();
        userService.saveListTar(idcurso,listActivi);
        modelAndView.addObject("listTa", listActivi);
        return modelAndView;
    }
    @RequestMapping(value = "/listActivi",method = RequestMethod.POST)
    public String saveListAct(@RequestParam int act_id,int idcurso,MultipartFile archivo,@Valid ListActivi listActivi, BindingResult bindingResult,ModelMap modelMap)throws IOException{
        ModelAndView modelAndView=new ModelAndView();
        Actividades act=new Actividades();
        if(bindingResult.hasErrors()){
            modelAndView.addObject("successMessage", "resiva datos");
            modelMap.addAttribute("bindingResult",bindingResult);
        }
       // act.setArchivo(archivo.getBytes());
       byte[] ar=archivo.getBytes();
        String ema=SecurityContextHolder.getContext().getAuthentication().getName();
        //ModelAndView modelAndView=new ModelAndView();
        userService.saveAct(act,ema,act_id,ar); 
        //modelAndView.addObject("act", act);
        return "redirect:/listActivi?idcurso="+idcurso+"";
    }
    @RequestMapping(value = "/saveusercursos",method = RequestMethod.GET)
    public String saveusercurso(@RequestParam(value = "id_curso")Integer id_curso){
        String ema=SecurityContextHolder.getContext().getAuthentication().getName();
        UsuCurso usuCurso=new UsuCurso();
        userService.saveusercursos(usuCurso,id_curso,ema);
        return "redirect:/home";
    }
   
    @RequestMapping("/nefi")
        public String ini(){
            return "nefi si";
        }
    
}