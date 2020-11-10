package com.cocinas.cocinaspro.Controller;

import java.util.Collection;

import com.cocinas.cocinaspro.Models.Muebles;
import com.cocinas.cocinaspro.Repository.MueblesRepo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
   private MueblesRepo mueblesRepo;
   public Controller(MueblesRepo mueblesRepo){
       super();
       this.mueblesRepo=mueblesRepo;
   }
   @RequestMapping(value = "/muebles")
   Collection<Muebles> muebles(){
       return mueblesRepo.findAll();
   }
}