package com.bankinformationjobs.web.rest;

import com.bankinformationjobs.domain.entity.Comentario;
import com.bankinformationjobs.service.ComentarioService;
import com.bankinformationjobs.service.dto.ComentarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class ComentariosController {

    @Autowired
    private ComentarioService comentarioService;

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

    @RequestMapping("/comentatiosProfesional/{id}")
    public String mostrarComentarios(Model model, @PathVariable(name = "id") Integer id) {
        
        List<Comentario> Comentarios = comentarioService.listComentarios(id);

        model.addAttribute("comentario", Comentarios);
        model.addAttribute("profesonalId", id);
        
        return "perfilProfesional";
    }
}
