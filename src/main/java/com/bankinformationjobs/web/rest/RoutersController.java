package com.bankinformationjobs.web.rest;

import com.bankinformationjobs.domain.entity.Comentario;
import com.bankinformationjobs.domain.entity.Profesional;
import com.bankinformationjobs.service.ComentarioService;
import com.bankinformationjobs.service.ProfesionalService;
import com.bankinformationjobs.service.dto.ProfesionalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
public class RoutersController {

    @Autowired
    private ProfesionalService profesionalService;
    @Autowired
    private ComentarioService comentarioService;

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

    @GetMapping("buscarProfesional")
    public String filterProfesional() {
        return "buscarProfesional";
    }

    @GetMapping("/home/buscarProfesional")
    public String buscarProfesional(Model modelo, @Param("palabraClave") String palabraClave) {
        List<Profesional> listaProfesionales = profesionalService.listAll(palabraClave);

        modelo.addAttribute("listaProfesionales", listaProfesionales);
        modelo.addAttribute("palabraClave", palabraClave);

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

    @RequestMapping("/editarProfesional/{id}")
    public ModelAndView mostrarFormularioActualizarProfesional(@PathVariable(name = "id") Integer id) {
        ModelAndView modelo = new ModelAndView("editarProfesional");

        Optional<Profesional> profesional = profesionalService.getProfesionalById(id);
        modelo.addObject("profesionalDto", profesional);

        return modelo;

    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarProfesionl(@PathVariable(name = "id") Integer id ) {
        profesionalService.eliminarProfesional(id);
        return "redirect:/home";
    }

    @RequestMapping("/perfilProfesional/{id}")
    public String mostrarPerfilProfesional(Model model, @PathVariable(name = "id") Integer id) {
        Profesional perfilProfesional = profesionalService.leerPerfil(id);
        List<Comentario> Comentarios = comentarioService.listComentarios(id);

        model.addAttribute("profesonalId", id);
        model.addAttribute("comentario", Comentarios);
        model.addAttribute("perfilPro", perfilProfesional);
        return "perfilProfesional";
    }
    @GetMapping("/home/perfilProfesional")
    public String viewPerfilProfesional(Model modelo) {
        return "perfilProfesional";
    }

}
