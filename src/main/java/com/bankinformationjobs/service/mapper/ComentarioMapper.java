package com.bankinformationjobs.service.mapper;

import com.bankinformationjobs.domain.entity.Comentario;
import com.bankinformationjobs.service.dto.ComentarioDto;

public class ComentarioMapper {

    public static ComentarioDto getComentarioDtoFromComentario(Comentario comentario) {
        if (comentario == null) {
            return null;
        }
        ComentarioDto dto = new ComentarioDto();
        //set variables
        dto.setIdComentario(comentario.getIdComentario());
        dto.setProfesional(comentario.getProfesional());
        dto.setUsuario(comentario.getUsuario());
        dto.setCalificacion(comentario.getCalificacion());
        dto.setComentario(comentario.getComentario());
        return dto;

    }

    public static Comentario getComentarioFromComentarioDto(ComentarioDto comentarioDto) {
        if (comentarioDto == null) {
            return null;
        }
        Comentario comentario = new Comentario();

        comentario.setIdComentario(comentarioDto.getIdComentario());
        comentario.setProfesional(comentarioDto.getProfesional());
        comentario.setUsuario(comentarioDto.getUsuario());
        comentario.setComentario(comentario.getComentario());
        comentario.setCalificacion(comentario.getCalificacion());
        return comentario;
    }

}
