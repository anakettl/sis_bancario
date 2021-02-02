package com.anakettl.sis_bancario.controllers;

import com.anakettl.sis_bancario.dto.ContaEspecialDto;
import com.anakettl.sis_bancario.models.ContaEspecial;
import com.anakettl.sis_bancario.service.AgenciaService;
import com.anakettl.sis_bancario.service.ClienteService;
import com.anakettl.sis_bancario.service.ContaEspecialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/contas-especiais")
public class ContaEspecialController {

    private ContaEspecialService contas_especiais;
    private ClienteService clientes;
    private AgenciaService agencias;

    public ContaEspecialController(ContaEspecialService contas_especiais, ClienteService clientes, AgenciaService agencias) {
        super();
        this.contas_especiais = contas_especiais;
        this.clientes = clientes;
        this.agencias = agencias;
    }

    @GetMapping("/create")
    public ModelAndView viewSalvar(ContaEspecialDto dto) {
        ModelAndView model = new ModelAndView("conta_especial/create");
        model.addObject("clientes", clientes.todos());
        model.addObject("agencias", agencias.todos());
        try {
            model.addObject("conta_especial", dto);
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            model.setViewName("error");
            return model;
        }
    }

    @PostMapping("/create")
    public ModelAndView salvar(ContaEspecialDto dto, BindingResult resultado, RedirectAttributes redirecionamento) {
        ModelAndView model = new ModelAndView("conta_especial/index");
            this.contas_especiais.salvar(dto.toEntity());
            return model;
    }

    @GetMapping
    public String todos(Model model) {
        try {
            List<ContaEspecial> lista = this.contas_especiais.todos();
            model.addAttribute("contas_especiais", lista);
            return "conta_especial/index";
        } catch (Exception exception) {
            model.addAttribute("erro", exception.getMessage());
            return "error";
        }
    }

    @GetMapping("/search")
    public ModelAndView viewSalvar(String texto, String tipo) {
        ModelAndView model = new ModelAndView("conta_especial/search");
        model.addObject("texto", texto);
        model.addObject("tipo", tipo);
        return model;
    }

    @PostMapping("/search")
    public String pesquisar(Model model, String texto, String tipo) {
        try {
            List<ContaEspecial> lista = new ArrayList<ContaEspecial>();
            switch (tipo) {
                case "1":
                    lista = this.contas_especiais.buscarContaEspecialPeloNumero(Long.parseLong(texto));
                    break;
                case "2":
                    lista = this.contas_especiais.buscarContaEspecialPelaAgencia(texto);
                    break;
                case "3":
                    lista = this.contas_especiais.buscarContaEspecialPeloCliente(texto);
                    break;
            }
            model.addAttribute("contas_especiais", lista);
            return "contas_especiais";
        } catch (Exception exception) {
            model.addAttribute("erro", exception.getMessage());
            return "error";
        }

    }

}
