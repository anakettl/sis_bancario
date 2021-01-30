package com.anakettl.sis_bancario.controllers;

import com.anakettl.sis_bancario.models.ContaEspecial;
import com.anakettl.sis_bancario.service.ContaEspecialService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public class ContaEspecialController {
    private ContaEspecialService contas_especiais;

    public ContaEspecialController(ContaEspecialService clientes) {
        this.contas_especiais = contas_especiais;
    }

    @GetMapping("/create")
    public ModelAndView viewSalvar(ContaEspecial conta_especial) {
        ModelAndView model = new ModelAndView("conta_especial/create");
        try {
            model.addObject("conta_especial", conta_especial);
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            model.setViewName("error");
            return model;
        }
    }

    @PostMapping("/create")
    public ModelAndView salvar(ContaEspecial conta_especial, BindingResult resultado, RedirectAttributes redirecionamento) {
        ModelAndView model = new ModelAndView("conta_especial/index");
        try {
            if (resultado.hasErrors()) {
                return viewSalvar(conta_especial);
            }
            this.contas_especiais.salvar(conta_especial);
            return model;
        }
        catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            return model;
        }
    }

    @GetMapping
    public String todos(Model model) {
        try {
            List<ContaEspecial> lista = this.contas_especiais.todos();
            model.addAttribute("contas_especiais", lista);
            return "cliente/index";
        } catch (Exception exception) {
            model.addAttribute("erro", exception.getMessage());
            return "error";
        }
    }
}
