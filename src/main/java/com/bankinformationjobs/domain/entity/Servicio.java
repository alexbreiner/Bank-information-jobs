package com.bankinformationjobs.domain.entity;


import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.*;
@Entity
@Table(name = "servicios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio", nullable = false, unique = true)
    private Integer idServicio;

    @ManyToOne
    @JoinColumn(name = "id_profesional", nullable = false, unique = true)
    private Profesional profesional;

    @Min(5)
    @Max(255)
    @Column(name = "categoria")
    private String categoria;

    @Column(name = "servicio")
    private String servicio;
}
