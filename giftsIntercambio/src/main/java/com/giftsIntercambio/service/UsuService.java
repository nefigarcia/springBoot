package com.giftsIntercambio.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.giftsIntercambio.model.UsuEntity;
import com.giftsIntercambio.repository.UsuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuService{
    String a,b;
 public  ArrayList<String> li=new ArrayList<>(Arrays.asList("Sanjuanita","Luis","Fabela","Benjamin","Nayeli","Issac","Sarita","Miguel","Saul",
    "Ingrid","Rebeca","Betel","Emma","Saulito","Elizabeth","Lulu","Gladis","Juan Manuel","Juan Manuel hijo","Dora Sofia",
    "Ana Paola","Michelle","Jorge","Dalay","Rusell","Yamilete","Susset","Miguel EsposoSusset","Neitan",
    "Rosa Gtz.","Nefi","Jared","Magaly","Kalel","Moroni","Darcy","Tristan","Torrence","Leonardo","Mary","Erick","David","Spencer",
    "Ezra","Karen","Ezra bebe","Aurora","Ricardo","Paola","Aurorita","Amauri","Susana","Amairito","Nikole","Stefani",
    "Zahid","Dely","Challines","Richi","Adrian","Laura","Valeria","Adrian bebe","Raul","Claudia","Cristian bebe","Vivian Cristian","Efrain","karen Efra","Vivian Efra",
    "Raquel","Julio","Vicky","Julio bebe","Rene","Vanesa","Memo"));
 
  @Autowired
  UsuRepository repository;
  ArrayList<String> lst=new ArrayList<>();

public List<UsuEntity> getAllUsuarios(){
 List<UsuEntity> result=(List<UsuEntity>) repository.findAll();
  if (result.size()>0) {
      return result;
  }else{
      return new ArrayList<UsuEntity>();
  }
 }
 public List<String> pa(){
    int ban=0; 
    Random r=new Random();
   
    ArrayList<Integer> li2=new ArrayList<>();//int ban2=0;
    int max=li.size()-1; int min=0;
    
    fo: for (int ban2=0;ban2<li.size(); ban2++) {
      ban=(int)r.nextInt((max-min)+1)+ min;
      while (li2.indexOf(ban)!=-1 ) {
        ban=(int)r.nextInt((max-min)+1)+ min;
      }
      li2.add(ban);
      if (ban2==li.size()-1) {
        if (li.get(ban2)==li.get(li2.get(ban2))) {
          ban2=-1;li2.clear();lst.clear();continue fo;
        }
      }

      if (li.get(ban2)==li.get(li2.get(ban2))) {
        while (li2.indexOf(ban)!=-1 ) {
          ban=(int)r.nextInt((max-min)+1)+ min;
        }
        li2.set(ban2,ban);
      }
      lst.add(li.get(li2.get(ban2)));
      System.out.println(li.get(ban2)+"---"+li.get(li2.get(ban2)));

     //  ban2++;
     } 
   return li;
 }
 public List<String> pa2(){
     return lst;
 }
}