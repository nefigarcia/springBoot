package com.giftsIntercambio.UsuController;
import com.giftsIntercambio.service.*;
import com.giftsIntercambio.model.UsuEntity;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UsuControllerWeb{
    ArrayList<UsuEntity> af=new ArrayList<>();
    @Autowired
    UsuService service;
   // @RequestMapping
    public String getAllUsuarios(Model model){
        List<UsuEntity> list=service.getAllUsuarios();
        model.addAttribute("usuarios", list);
        return "list-usuarios";
    }
    @RequestMapping
    public String getAlla(Model model){
        int i=0;
        List<String> list=service.pa();
        for (String var : list) {
            af.add(new UsuEntity(var,service.pa2().get(i)));
            i++;
        }i=0;
        model.addAttribute("usuarios2", af);
        return "list-usuarios";
    }
    @RequestMapping(path="/intercambio")
    public String getAlla2(Model model){
        //int i=0;
        List<UsuEntity> list=af;
       
        model.addAttribute("usuarios2", list);
        return "list-usuarios";
    }
}