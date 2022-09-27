package com.bankinformationjobs.service.dto;

import com.bankinformationjobs.domain.entity.Profesional;
import com.bankinformationjobs.domain.entity.User;
import org.hibernate.validator.constraints.Length;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioDto implements Serializable {

    @Length(min = 1)
    private Integer idComentario;

    private Profesional profesional;

    private User user;

    @Length(max = 5)
    private int calificacion;

    @Length(max = 255)
    private String comentario;
}
