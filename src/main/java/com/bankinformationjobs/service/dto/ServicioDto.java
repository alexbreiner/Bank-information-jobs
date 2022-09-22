package com.bankinformationjobs.service.dto;

import com.bankinformationjobs.domain.entity.Profesional;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
public class ServicioDto implements Serializable {

    @Length(min = 1)
    private Integer idServicio;

    private Profesional profesional;

    @Min(5)
    @Max(40)
    @Column(name = "categoria")
    private String categoria;

    @Column(name = "servicio")
    private String servicio;
}
