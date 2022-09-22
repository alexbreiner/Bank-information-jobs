package com.bankinformationjobs.domain.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "profesional")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Profesional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesional", nullable = false, updatable = false)
    private Integer idProfesional;

    @NotNull
    @Length(max = 40)
    @Column(name = "nombre")
    private String nombre;


    @NotNull
    @Length(max = 40)
    @Column(name = "apellido")
    private String apellido;

    @NotNull
    @Length(max = 255)
    @Column(name = "profesion")
    private String profesion;

    @NotNull
    @Length(max = 10)
    @Column(name = "telefono")
    private String telefono;

    @NotNull
    @NotBlank()
    @Valid()
    @Pattern(regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$")
    @Column(name = "correo")
    private String correo;

    @NotNull
    @Length(max = 40)
    @Column(name = "ciudad")
    private String ciudad;

    @NotNull
    @Length(max = 40)
    @Column(name = "barrio")
    private String barrio;


    @Column(name = "direccion")
    private String direccion;

    @NotNull
    @Column(name = "imageUrl", length = 1000)
    private String imageUrl;
}
