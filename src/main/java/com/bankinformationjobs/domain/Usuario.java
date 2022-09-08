package com.bankinformationjobs.domain;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

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
