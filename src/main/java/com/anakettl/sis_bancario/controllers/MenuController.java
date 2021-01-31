package com.anakettl.sis_bancario.controllers;

import com.anakettl.sis_bancario.models.MenuEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MenuController {

    @GetMapping("/")
    public String menu(Model model){
        model.addAttribute("opcoes", MenuEnum.values());
        return "menu";
    }

}