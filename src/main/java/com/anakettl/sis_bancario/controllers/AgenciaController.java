package com.anakettl.sis_bancario.controllers;

import com.anakettl.sis_bancario.models.Agencia;
import com.anakettl.sis_bancario.service.AgenciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/agencias")
public class AgenciaController {

    private AgenciaService agencias;

    public AgenciaController(AgenciaService agencias) {
        this.agencias = agencias;
    }

    @GetMapping("/create")
    public ModelAndView viewSalvar(Agencia agencia) {
        ModelAndView model = new ModelAndView("agencia/create");
        try {
            model.addObject("agencia", agencia);
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            model.setViewName("exemplo");
            return model;
        }
    }

    @PostMapping("/create")
    public ModelAndView salvar(Agencia agencia, BindingResult resultado, RedirectAttributes redirecionamento) {
        ModelAndView model = new ModelAndView("agencia/index");
        try {
            if (resultado.hasErrors()) {
                return viewSalvar(agencia);
            }
            this.agencias.salvar(agencia);
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            return model;
        }
    }

    @GetMapping
    public String todos(Model model) {
        try {
            List<Agencia> lista = this.agencias.todos();
            model.addAttribute("agencias", lista);
            return "agencia/index";
        } catch (Exception exception) {
            model.addAttribute("erro", exception.getMessage());
            return "error";
        }
    }
}
