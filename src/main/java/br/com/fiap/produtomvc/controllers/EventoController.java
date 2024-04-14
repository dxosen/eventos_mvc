package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.models.Cidade;
import br.com.fiap.produtomvc.models.Evento;
import br.com.fiap.produtomvc.services.CidadeService;
import br.com.fiap.produtomvc.services.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @Autowired
    private CidadeService cidadeService;

    @ModelAttribute("cidades")
    public List<Cidade> cidades(){
        return cidadeService.findAll();
    }

    @GetMapping("/form")
    public String loadForm(Model model) {
        model.addAttribute("evento", new Evento());
        return "evento/novo-evento";
    }

    @PostMapping()
    public String insert(@Valid Evento evento,
                                BindingResult result,
                                RedirectAttributes attributes) {
        if(result.hasErrors()){
            return "evento/novo-evento";
        }
        evento = service.insert(evento);
        attributes.addFlashAttribute("mensagem", "Evento salvo com sucesso");
        return "redirect:/eventos/form";
    }

    @GetMapping()
    public String findAll(Model model){
        model.addAttribute("eventos", service.findAll());
        return "/evento/listar-eventos";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable ("id") Long id, Model model ){
        Evento evento = service.findById(id);
        model.addAttribute("evento", evento);
        return "/evento/editar-evento";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                                @Valid Evento evento,
                                BindingResult result){
        if(result.hasErrors()){
            evento.setId(id);
            return "/evento/editar-evento";
        }
        service.update(id, evento);
        return "redirect:/eventos";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        service.delete(id);
        return "redirect:/eventos";
    }
}










