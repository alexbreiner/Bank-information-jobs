package com.bankinformationjobs.service;

import com.bankinformationjobs.domain.entity.Comentario;
import com.bankinformationjobs.service.dto.ComentarioDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComentarioService {

     ResponseEntity<ComentarioDto> crearComentario(ComentarioDto comentarioDto);

     //Get
     public Page<ComentarioDto> read(Integer pageSize, Integer pageNumber, String sort, String dir);

     ComentarioDto updateComentario(ComentarioDto comentarioDto);

     void delete(Integer id);

     List<ComentarioDto> readList();



}
