package com.bankinformationjobs.domain;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;

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
    @Column(name = "id_profesional")
    private Integer idProfesional;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "profesion")
    private String profesion;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "barrio")
    private String barrio;

    @Column(name = "direccion")
    private String direccion;
}
