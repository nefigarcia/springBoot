package com.example.log;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonPerform{
    @NotNull
    @Size(min=2,max=21)
    private String name;

    @NotNull
    @Size(min=10)
    private Integer age;

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAge(Integer age){
        this.age=age;
    }
    public Integer setName(){
        return age;
    }
    public String toString(){
        return "name"+this.name+"age="+this.age;
    }
} 
