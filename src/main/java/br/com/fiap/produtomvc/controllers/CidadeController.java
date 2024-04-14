package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.models.Cidade;
import br.com.fiap.produtomvc.services.CidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping("/form")
    public String loadFormCategoria(Model model) {
        model.addAttribute("cidade", new Cidade());
        return "cidade/nova-cidade";
    }

    @PostMapping()
    public String insert(@Valid Cidade cidade,
                         BindingResult result,
                         RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "cidade/nova-cidade";
        }
        cidade = service.insert(cidade);
        attributes.addFlashAttribute("mensagem", "Cidade salva com sucesso!");
        return "redirect:/cidades";
    }

    @GetMapping()
    public String findAll(Model model) {
        List<Cidade> cidades = service.findAll();
        model.addAttribute("cidades", cidades);
        return "/cidade/listar-cidades";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        Cidade cidade = service.findById(id);
        model.addAttribute("cidade", cidade);
        return "/cidade/editar-cidade";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid Cidade cidade,
                         BindingResult result) {
        if (result.hasErrors()) {
            cidade.setId(id);
            return "/cidade/editar-cidade";
        }
        service.update(id, cidade);
        return "redirect:/cidades";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        return "redirect:/cidades";
    }

}










