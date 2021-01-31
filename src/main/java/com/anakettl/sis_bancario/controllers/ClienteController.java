package com.anakettl.sis_bancario.controllers;

import com.anakettl.sis_bancario.models.Cliente;
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
@RequestMapping(value = "/clientes")
public class ClienteController {

    private ClienteService clientes;

    public ClienteController(ClienteService clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/create")
    public ModelAndView viewSalvar(Cliente cliente) {
        ModelAndView model = new ModelAndView("cliente/create");
        try {
            model.addObject("cliente", cliente);
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            model.setViewName("error");
            return model;
        }
    }

    @PostMapping("/create")
    public ModelAndView salvar(Cliente cliente, BindingResult resultado, RedirectAttributes redirecionamento) {
        ModelAndView model = new ModelAndView("cliente/index");
        try {
            Boolean clienteValido = clientes.validarCpf(cliente.cpf);
            if (clienteValido==false) {
                return viewSalvar(cliente);
            }
            this.clientes.salvar(cliente);
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
            List<Cliente> lista = this.clientes.todos();
            model.addAttribute("clientes", lista);
            return "cliente/index";
        } catch (Exception exception) {
            model.addAttribute("erro", exception.getMessage());
            return "error";
        }
    }
}
