package com.bankinformationjobs.service.dto;

import com.bankinformationjobs.domain.entity.Profesional;
import com.bankinformationjobs.domain.entity.Usuario;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class ComentarioDto implements Serializable {

    @NotNull
    private Integer idComentario;
    private Profesional profesional;
    private Usuario usuario;
    private int calificacion;
    private String comentario;
}
