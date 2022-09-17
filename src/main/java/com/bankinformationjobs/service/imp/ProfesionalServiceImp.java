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


@Service
public class ProfesionalServiceImp implements ProfesionalService {

    @Autowired
    ProfesionalRepository profesionalRepository;

    @Override
    public ResponseEntity<ProfesionalDto> crearProfesional(ProfesionalDto profesionalDto) {

        Profesional profesional = ProfesionalMapper.getProfesionalFromProfesionalDto(profesionalDto);

       /* if (Objects.isNull(profesional) || Objects.isNull(profesional.getIdProfesional())) {
            throw new RuntimeException("Profesional not found");
        }*/

        if (profesionalRepository.findById(profesionalDto.getIdProfesional()).isPresent()) {
            return new ResponseEntity("El codigo del profesional ya existe", HttpStatus.BAD_REQUEST);
        } else {
          return new ResponseEntity(ProfesionalMapper.getProfesionalDtoFromProfesional(profesionalRepository.save(profesional)), HttpStatus.OK);
        }

    }

    @Override
    public Page<ProfesionalDto> listarProfesionalesPaginados(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageSize, pageNumber);
        return  profesionalRepository.findAll(pageable).map(ProfesionalMapper::getProfesionalDtoFromProfesional);
    }

    @Override
    public List<Profesional> leerTodosProfesionals() {
        return profesionalRepository.findAll();
    }

    @Override
    public ResponseEntity<Profesional> actualizarProfesional(Profesional profesional) {
        return null;
    }

    @Override
    public List<Profesional> getProfesionalPorNombre(String nombreProfesional) {
        return null;
    }

    @Override
    public void eliminarProfesional(Long id) {

    }
}
