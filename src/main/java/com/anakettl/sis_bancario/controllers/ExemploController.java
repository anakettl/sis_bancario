package com.anakettl.sis_bancario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExemploController {

    @GetMapping("/")
    public String exemplo(){
        return "exemplo";
    }
}