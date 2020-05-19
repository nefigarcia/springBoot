package com.jso;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.boot.web.bind.annotation.*;
import org.springframework.boot.SpringApplication;



@RestController
@EnableAutoConfiguration
public class BluediveApplication{
    @RequestMapping("/")
    String Home(){
        return "Bienvenido";
    }
    public static void main(String[] args) {
        SpringApplication.run(BluediveApplication.class,args);
    }
}