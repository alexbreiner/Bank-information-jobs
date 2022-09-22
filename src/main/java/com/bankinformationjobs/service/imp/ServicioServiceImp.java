package com.bankinformationjobs.service.imp;

import com.bankinformationjobs.domain.entity.Servicio;
import com.bankinformationjobs.repository.ServicioRepository;
import com.bankinformationjobs.service.ServicioService;
import com.bankinformationjobs.service.dto.ServicioDto;
import com.bankinformationjobs.service.mapper.ServicioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioServiceImp implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public ResponseEntity<ServicioDto> saveService(ServicioDto servicioDto) {
        Servicio servicio = ServicioMapper.getServiceFromServiceDto(servicioDto);
        if (Objects.isNull(servicio)) throw new RuntimeException("El servicio es null");
        return new ResponseEntity(ServicioMapper.getServiceDtoFromService(servicioRepository.save(servicio)), HttpStatus.OK);
    }

    @Override
    public List<ServicioDto> getAllService() {
        if (Objects.isNull(servicioRepository.findAll())) throw new RuntimeException("No hay informacion de servicios");
        return servicioRepository.findAll().stream().map(ServicioMapper::getServiceDtoFromService).collect(Collectors.toList());
    }

    @Override
    public void deleteService(Integer id) {
        if (id == null) throw new RuntimeException("El id es null");
        servicioRepository.deleteById(id);
    }

    @Override
    public Optional<Servicio> getServicioById(Integer id) {
        if (id == null) throw new RuntimeException("El id es null");
        return servicioRepository.findById(id);
    }
}
