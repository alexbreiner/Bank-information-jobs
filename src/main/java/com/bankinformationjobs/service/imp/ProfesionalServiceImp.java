package com.bankinformationjobs.service.imp;

import com.bankinformationjobs.domain.entity.Profesional;
import com.bankinformationjobs.repository.ProfesionalRepository;
import com.bankinformationjobs.service.ProfesionalService;
import com.bankinformationjobs.service.dto.ProfesionalDto;
import com.bankinformationjobs.service.mapper.ProfesionalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProfesionalServiceImp implements ProfesionalService {

    @Autowired
    ProfesionalRepository profesionalRepository;

    @Override
    public ResponseEntity<ProfesionalDto> crearProfesional(ProfesionalDto profesionalDto) {
        Profesional profesional = ProfesionalMapper.getProfesionalFromProfesionalDto(profesionalDto);

       /* if (Objects.isNull(profesional) || Objects.isNull(profesional.getIdProfesional())) {
            throw new RuntimeException("Profesional no encontrado.");
        }*/

       /* if (profesionalRepository.findById(profesionalDto.getIdProfesional()).isPresent()) {
            return new ResponseEntity("El codigo del profesional ya existe", HttpStatus.BAD_REQUEST);
        } else {

        */
            return new ResponseEntity(ProfesionalMapper.getProfesionalDtoFromProfesional(profesionalRepository.save(profesional)), HttpStatus.OK);
        }

    

    @Override
    public Page<ProfesionalDto> listarProfesionalesPaginados(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageSize, pageNumber);
        if (Objects.isNull(pageable)){
            throw new RuntimeException("Informacion no encontrada.");
        }

        return  profesionalRepository.findAll(pageable).map(ProfesionalMapper::getProfesionalDtoFromProfesional);
    }

    @Override
    public List<Profesional> leerTodosProfesionals() {
        return profesionalRepository.findAll();
    }

    @Override
    public ResponseEntity<ProfesionalDto> actualizarProfesional(ProfesionalDto profesionalDto) {
        Profesional profesional1 = ProfesionalMapper.getProfesionalFromProfesionalDto(profesionalDto);
        if(Objects.isNull(profesional1)) {
            throw new RuntimeException("No se puede actualizar el usuario.");
        }
        return new ResponseEntity(ProfesionalMapper.getProfesionalDtoFromProfesional(profesionalRepository.save(profesional1)), HttpStatus.OK);
    }

    @Override
    public void eliminarProfesional(Integer id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException("No se puede eliminar el usuario." + id);
        }
        profesionalRepository.deleteById(id);
    }

    @Override
    public List<ProfesionalDto> readList() {
        if(profesionalRepository.findAll() == null) {
            throw new RuntimeException("No hay informacion de profesionales.");
        }
        return profesionalRepository.findAll().stream().map(ProfesionalMapper::getProfesionalDtoFromProfesional).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ProfesionalDto> search(String ciudad, String profesion) {

        if (Objects.isNull(ciudad) && Objects.isNull(profesion)) {
            throw new RuntimeException("No coincide la información solicitada.");
        }

        if (Objects.nonNull(ciudad)) {
            return new ResponseEntity(profesionalRepository.findProfesionalByCiudad(ciudad.toUpperCase()), HttpStatus.OK);
        } else if (Objects.nonNull(profesion)) {
            return new ResponseEntity(profesionalRepository.findProfesionalByProfesion(profesion.toUpperCase()), HttpStatus.OK);
        } else return new ResponseEntity("Error en la consulta.", HttpStatus.BAD_REQUEST);
    }

    @Override
    public Optional<Profesional> searchForName(String nombre) {
        if (Objects.isNull(nombre.toUpperCase())) {
            throw new RuntimeException("No coincide la información solicitada.");
        }
        return  profesionalRepository.findProfesionalByNombre(nombre);
    }

    @Override
    public Optional<Profesional> getProfesionalById(Integer id) {
        return profesionalRepository.findById(id);
    }

    @Override
    public List<Profesional> listAll(String nombreAtributo) {

        //if (Objects.isNull(nombreAtributo.toUpperCase()) || nombreAtributo.toUpperCase().equals(null)) {
         //   throw new RuntimeException("Informacion no encontrada, Intente de nuevo.");
        //} else if (Objects.nonNull(nombreAtributo.toUpperCase())) {
            return profesionalRepository.findAll(nombreAtributo);
        //}
       // return profesionalRepository.findAll();
    }

    @Deprecated
    public Profesional leerPerfil(Integer id){
        return profesionalRepository.getById( id);
    }



    


    

    
	


}
