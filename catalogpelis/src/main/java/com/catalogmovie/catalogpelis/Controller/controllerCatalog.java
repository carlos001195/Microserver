package com.catalogmovie.catalogpelis.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/catalog")

public class controllerCatalog {

    @PostMapping("/{namemovie}")
    private String movie(@PathVariable(value = "namemovie") String name) {

        return name;

    }

}
