package com.bankinformationjobs.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "solicitudes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Solicitud implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud", nullable = false, unique = true)
    private Integer idSolicitud;

    @ManyToOne
    @JoinColumn(name = "id_profesional")
    private Profesional profesional;

    // @ManyToOne
    // @JoinColumn(name = "id_usuario")
    // private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    @Column(name = "fecha")
    private Date fecha;
}
