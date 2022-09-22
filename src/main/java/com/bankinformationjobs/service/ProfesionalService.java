package com.bankinformationjobs.service;

import com.bankinformationjobs.domain.entity.Profesional;
import com.bankinformationjobs.service.dto.ProfesionalDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import java.util.*;

public interface ProfesionalService {

    ResponseEntity<ProfesionalDto> crearProfesional(ProfesionalDto profesionalDto);

     Page<ProfesionalDto>  listarProfesionalesPaginados(Integer pageSize, Integer pageNumber);

     List<Profesional> leerTodosProfesionals();

     ResponseEntity<ProfesionalDto> actualizarProfesional(ProfesionalDto profesionalDto);

     void eliminarProfesional(Integer id);

     List<ProfesionalDto> readList();

     ResponseEntity<ProfesionalDto> search(String ciudad,  String profesion);

     Optional<Profesional> searchForName(String nombre);

     Optional<Profesional> getProfesionalById(Integer id);

     List<Profesional> listAll(String nombreAtributo);
}
