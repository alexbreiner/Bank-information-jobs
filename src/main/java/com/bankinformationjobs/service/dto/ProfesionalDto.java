package com.bankinformationjobs.service.dto;


import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


@Getter
@Setter
public class ProfesionalDto implements Serializable {

    @Length(min = 1)
    private Integer idProfesional;

    @Length(max = 40)
    private String nombre;

    @Length(max = 40)
    private String apellido;

    @Length(max = 255)
    private String profesion;

    @Length( max = 10)
    private String telefono;

    @NotBlank()
    @Valid()
    @Pattern(regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$")
    @Length( max = 40)
    private String correo;

    @Length( max = 30)
    private String ciudad;

    @Length( max = 20)
    private String barrio;

    @Length( max = 40)
    private String direccion;

    @Length(max = 500)
    private String imageUrl;

}
