package com.bankinformationjobs.service.imp;

import com.bankinformationjobs.domain.entity.Comentario;
import com.bankinformationjobs.repository.ComentarioRepository;
import com.bankinformationjobs.service.ComentarioService;
import com.bankinformationjobs.service.dto.ComentarioDto;
import com.bankinformationjobs.service.mapper.ComentarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImp implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public ResponseEntity<ComentarioDto> crearComentario(ComentarioDto comentarioDto) {
        Comentario comentario = ComentarioMapper.getComentarioFromComentarioDto(comentarioDto);
        // if (comentarioRepository.findById(comentario.getIdComentario()).isPresent()) {
        //     return new ResponseEntity("El comentario ya exite", HttpStatus.BAD_REQUEST);
        // }
        return new ResponseEntity(ComentarioMapper.getComentarioDtoFromComentario(comentarioRepository.save(comentario)), HttpStatus.OK);
    }

    @Override
    public Page<ComentarioDto> read(Integer pageSize, Integer pageNumber, String sort, String dir) {
        Pageable pageable;
        if (Objects.isNull(sort)) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.valueOf(dir.toUpperCase()), sort));
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        }
        return comentarioRepository.findAll(pageable).map(ComentarioMapper::getComentarioDtoFromComentario);
    }

    @Override
    public ComentarioDto updateComentario(ComentarioDto comentarioDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public List<ComentarioDto> readList() {
        return comentarioRepository.findAll().stream().map(ComentarioMapper::getComentarioDtoFromComentario).collect(Collectors.toList());
    }

    @Override
    public List<Comentario> listComentarios(Integer profesionalId) {
        return comentarioRepository.findByProfesionalId(profesionalId);
    }
}
