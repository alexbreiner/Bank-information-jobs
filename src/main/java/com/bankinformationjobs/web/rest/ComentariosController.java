package com.bankinformationjobs.web.rest;

import com.bankinformationjobs.domain.entity.Profesional;
import com.bankinformationjobs.service.ComentarioService;
import com.bankinformationjobs.service.ProfesionalService;
import com.bankinformationjobs.service.dto.ComentarioDto;
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
public class ComentariosController {

    @Autowired
    private ComentarioService comentarioService;


    @GetMapping("/home/saveProfesional")
    public String mostrarFormularioProfesional(Model modelo) {
        return "crearProfesional";
    }

    @PostMapping("/saveComentario")
    public String guardarComentario(@ModelAttribute("comentariolDto") ComentarioDto comentarioDto) {
        comentarioService.crearComentario(comentarioDto);
        return "redirect:/perfilProfesional";
    }

    

    @RequestMapping("/eliminarComentario/{id}")
    public String eliminarProfesionl(@PathVariable(name = "id") Integer id ) {
        comentarioService.delete(id); 
        return "redirect:/perfilProfesional";
    }

    @GetMapping("/perfilProfesional/")
    public String mostrarComentarios(Model model)  {

        List<ComentarioDto> Comentarios = comentarioService.readList();
        model.addAttribute("comentarios", Comentarios);
        return "perfilProfesional";
    }
    @GetMapping("/home/perfilProfesional")
    public String mostrarPerfilProfesional(Model modelo) {
        return "perfilProfesional";
    }

}
