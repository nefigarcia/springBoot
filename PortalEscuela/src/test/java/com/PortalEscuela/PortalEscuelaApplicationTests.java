package com.PortalEscuela;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.PortalEscuela.controller.AuthenticationController;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PortalEscuelaApplicationTests {

	@Test
	void contextLoads() {
		AuthenticationController auth=new AuthenticationController();
		String res=auth.ini();
		assertEquals(res, "actual, message");
	}

}
