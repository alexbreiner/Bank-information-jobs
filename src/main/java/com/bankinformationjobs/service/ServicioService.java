package com.bankinformationjobs.service;

import com.bankinformationjobs.domain.entity.Servicio;
import com.bankinformationjobs.service.dto.ServicioDto;
import org.springframework.http.ResponseEntity;

import java.util.*;

public interface ServicioService {

    ResponseEntity<ServicioDto> saveService(ServicioDto servicioDto);

    List<ServicioDto> getAllService();

    void deleteService(Integer id);

    Optional<Servicio> getServicioById(Integer id);
}
