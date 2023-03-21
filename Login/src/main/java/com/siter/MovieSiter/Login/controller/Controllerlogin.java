package com.siter.MovieSiter.Login.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.siter.MovieSiter.Login.Service.Serviceloguen;
import com.siter.MovieSiter.Login.model.user;

@RestController
public class Controllerlogin {

    @Autowired
    private Serviceloguen login;

    @PostMapping("/token")
    private String token() {
        return login.token();
    }

    @PostMapping("/countRegster")
    private String usuario(@RequestBody user user) {
        return login.createuser(user );
    }
    @PostMapping("/selectUser")
    private ResponseEntity<Object> sUser() {
        return new ResponseEntity<>( login.Selectuser(),HttpStatus.OK);
    }

}
