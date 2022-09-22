package com.bankinformationjobs.service.mapper;

import com.bankinformationjobs.domain.entity.Servicio;
import com.bankinformationjobs.service.dto.ServicioDto;

public class ServicioMapper {

    public static ServicioDto getServiceDtoFromService(Servicio servicio) {
        if (servicio == null) {
            return null;
        }
        ServicioDto dto = new ServicioDto();
        dto.setIdServicio(dto.getIdServicio());
        dto.setServicio(dto.getServicio());
        dto.setProfesional(dto.getProfesional());
        dto.setCategoria(dto.getCategoria());
        return dto;
    }

    public static Servicio getServiceFromServiceDto(ServicioDto servicioDto) {
        if (servicioDto == null) {
            return null;
        }
        Servicio servicio = new Servicio();
        servicio.setIdServicio(servicio.getIdServicio());
        servicio.setServicio(servicio.getServicio());
        servicio.setProfesional(servicio.getProfesional());
        servicio.setCategoria(servicio.getCategoria());
        return servicio;
    }
}
