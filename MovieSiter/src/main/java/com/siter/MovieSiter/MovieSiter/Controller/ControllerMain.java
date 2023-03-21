package com.siter.MovieSiter.MovieSiter.Controller;

import java.util.Date;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siter.MovieSiter.MovieSiter.Model.user;

@RestController
@RequestMapping(value = "/moviesiter")
public class ControllerMain {
    private final static String url_user = "http://127.0.0.1:8082";
    private final String url_catalogo = "http://127.0.0.1:8083";
    private final String url_video = "http://127.0.0.1:8084";

    @PostMapping("user/session") // show date of user
    private String session() {
        RestTemplate res = new RestTemplate();
        return res.postForObject(url_user + "/token", null, String.class);
    }

    @PostMapping("user/count")
    private ResponseEntity<Object> count(@Validated @RequestBody user json) {
        String dato="";

        try {
            RestTemplate res = new RestTemplate();
            dato = res.postForObject(url_user + "/countRegster", json, String.class);
        } catch (org.springframework.http.converter.HttpMessageNotReadableException e) {
            return new ResponseEntity<>("se Espera un json", HttpStatus.ACCEPTED);

        }

        return new ResponseEntity<>("uusario registrado", HttpStatus.CREATED);
    }

    @GetMapping("/user/all")
    
    private user[] users() throws JsonMappingException, JsonProcessingException {
        RestTemplate res = new RestTemplate();

        String json = res.postForObject(url_user + "/selectUser", null, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        user[] us = objectMapper.readValue(json, user[].class);

        return us;

    }

    @GetMapping("/catalogo/{namemovie}")
    private String  cargadecatalogo(@PathVariable(value = "namemovie") String name) {
        RestTemplate res = new RestTemplate();
        String movis = null;
        try {
            movis = res.postForObject(String.format("%s%s", url_catalogo + "/catalog/", name.trim().toLowerCase()),
                    null, String.class);

        } catch (RestClientException e) {
            movis = e.getMessage().intern().toString();
        }
        return movis;

    }

    @GetMapping("/catalogo/video/{namemovie}")
    private String cargadevideos(@PathVariable(value = "namemovie") String name) {
        RestTemplate res = new RestTemplate();
        String movis = null;
        try {
            movis = res.postForObject(String.format("%s%s", url_video + "/catalogVideo/api-v1/", name.trim().toLowerCase()),
                    null, String.class);

        } catch (RestClientException e) {
            movis = e.getMessage().intern().toString();
        }
        return movis;

    }

}
