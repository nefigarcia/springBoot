package com.PortalEscuela;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
    @Autowired
    DataSource datasource;
  @Bean
  public BCryptPasswordEncoder passwordEncoder(){
      BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
      return bCryptPasswordEncoder;
  }
 /* @Bean
  public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception{
    JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager();
    jdbcUserDetailsManager.setDataSource(datasource);
    return jdbcUserDetailsManager;
  }
  */
  
}