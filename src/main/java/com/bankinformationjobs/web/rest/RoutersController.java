package com.bankinformationjobs.web.rest;

import com.bankinformationjobs.domain.entity.Profesional;
import com.bankinformationjobs.service.IProfesionalService;
import com.bankinformationjobs.service.dto.ProfesionalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoutersController {

    @Autowired
    private IProfesionalService profesionalService;

    @GetMapping({"/home", "/"})
    public String index(Model modelo) {
        List<Profesional> profesionals = profesionalService.leerTodosProfesionals();
        modelo.addAttribute("profesionales", profesionals);
        return "home";
    }

    @GetMapping("/home/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/home/registro")
    public String Registro(Model model) {
        return "registro";
    }

    @GetMapping("/home/profesionalPaginates")
    public String profesionalesPaginates(Model modelo, @RequestParam("pageNumber") Integer pageNumber, @RequestParam Integer pageSize) {
        Page pages =  profesionalService.listarProfesionalesPaginados(pageSize, pageNumber);
        modelo.addAttribute("pages", pages);
        return "profesionalesPaginados";
    }

    @GetMapping("/home/buscarProfesional")
    public String buscarProfesional(Model modelo) {
        return "buscarProfesional";
    }

    @GetMapping("/home/saveProfesional")
    public String mostrarFormularioProfesional(Model modelo) {
        return "crearProfesional";
    }

    @PostMapping("/saveProfesional")
    public String guardarProfesional(@ModelAttribute("profesionalDto") ProfesionalDto profesionalDto) {
        profesionalService.crearProfesional(profesionalDto);
        return "redirect:/home";
    }

}
