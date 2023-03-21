package com.siter.MovieSiter.Login.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siter.MovieSiter.Login.Repository.Iuser;
import com.siter.MovieSiter.Login.model.user;


@Service
public class Serviceloguen implements i_login {

   @Autowired
   private Iuser usuario;

   @Override
   public String token() {
      return UUID.randomUUID().toString();
   }

   @Override
   public String createuser(user s) {
         
      
      usuario.save(s);
    
      return "Registro Exitoso";

   }

   @Override
   public List<user> Selectuser() {
         return ( List<user>) usuario.findAll();
   }

}
