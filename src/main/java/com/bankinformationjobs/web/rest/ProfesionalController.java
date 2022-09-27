package com.bankinformationjobs.web.rest;

import com.bankinformationjobs.domain.entity.Profesional;
import com.bankinformationjobs.service.ProfesionalService;
import com.bankinformationjobs.service.dto.ProfesionalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ProfesionalController {

    @Autowired
    ProfesionalService profesionalService;

    @PostMapping("/professionals")
    public ResponseEntity create(@RequestBody ProfesionalDto profesionalDto) {
        return profesionalService.crearProfesional(profesionalDto);
    }
    @GetMapping("/professionals")
    public Page<ProfesionalDto> readPaginated(@RequestParam(value = "pageSize") Integer pageSize,
                                                @RequestParam(value = "pageNumber") Integer pageNumber) {
        return profesionalService.listarProfesionalesPaginados(pageSize, pageNumber);
    }

    @PutMapping("/professional")
    public ResponseEntity<ProfesionalDto> update(@RequestBody ProfesionalDto profesionalDto) {
        return profesionalService.actualizarProfesional(profesionalDto);
    }

    @DeleteMapping("/professionals/{id}")
    public void delete(@PathVariable Integer id) {
        profesionalService.eliminarProfesional(id);
    }

    @GetMapping("profesionals/search")
    public ResponseEntity<ProfesionalDto> searchProfesional(@RequestParam(value = "ciudad" , required = false) String ciudad,
                                            @RequestParam(value = "profesion", required = false) String profesion) {
        return profesionalService.search(ciudad, profesion);
    }

    @GetMapping("/profesionals/get-list")
    public List<ProfesionalDto> getAllProfesionalList() {
        return profesionalService.readList();
    }

    @GetMapping("/profesionals/searchForName")
    public Optional<Profesional> searchProfesionalsForName(@RequestParam(value = "nombre") String nombre) {
        return profesionalService.searchForName(nombre);
    }

    @GetMapping("/profesional/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Profesional> getProfesionalById(@PathVariable Integer id) {
        //  LOG.info(new StringBuilder("User: ").append(principal.getName()).append(" requesting for person: ").append(id).toString());

        return profesionalService.getProfesionalById(id);
    }

}
