package com.PortalEscuela;
import org.junit.Test;


import com.PortalEscuela.Models.UserModel;
import com.PortalEscuela.Repository.UserRepo;
import com.PortalEscuela.Services.UserService;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;


public class JunitTests {
  
    @Test
    public void tt(){
        int x=2,z=2;
        Assert.assertEquals(2, x+z);
    }
}