package com.bankinformationjobs.service.dto;

import com.bankinformationjobs.domain.entity.Profesional;
import com.bankinformationjobs.domain.entity.Usuario;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Getter
@Setter
public class ComentarioDto implements Serializable {

    
    @Length(min = 1)
    private Integer idComentario;

    
    private Profesional profesional;

    private Usuario usuario;

    @Length(max = 5)
    private int calificacion;

    @Length(max = 255)
    private String comentario;
}
