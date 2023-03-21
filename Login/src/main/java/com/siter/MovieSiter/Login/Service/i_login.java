package com.siter.MovieSiter.Login.Service;

import java.util.List;

import com.siter.MovieSiter.Login.model.user;



public interface i_login {
    public  String token();
    public String createuser(user user);
    public List<user> Selectuser();
    
   
}
