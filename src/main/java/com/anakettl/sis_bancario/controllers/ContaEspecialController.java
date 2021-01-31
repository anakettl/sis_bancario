package com.anakettl.sis_bancario.controllers;

import com.anakettl.sis_bancario.models.ContaEspecial;
import com.anakettl.sis_bancario.service.AgenciaService;
import com.anakettl.sis_bancario.service.ContaEspecialService;
import com.anakettl.sis_bancario.service.ClienteService;
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
@RequestMapping(value = "/contas_especiais")
public class ContaEspecialController {

    private ContaEspecialService contas_especiais;

    private ClienteService clientes;

    private AgenciaService agencias;

    public ContaEspecialController(ContaEspecialService contas_especiais, ClienteService clientes, AgenciaService agencias) {

        this.contas_especiais = contas_especiais;
        this.clientes = clientes;
        this.agencias = agencias;
    }

    @GetMapping("/create")
    public ModelAndView viewSalvar(ContaEspecial conta_especial) {
        ModelAndView model = new ModelAndView("conta_especial/create");
        model.addObject("clientes", clientes.todos());
        model.addObject("agencias", agencias.todos());
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
