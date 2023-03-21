package com.catalogvideo.catalogovideos.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/catalogVideo")
public class controllerVideos {

    @PostMapping("/api-v1/{nameVideo}")
    private String   listvideos(@PathVariable(name = "nameVideo") String nameVideo) {
        return nameVideo;
    }

}
