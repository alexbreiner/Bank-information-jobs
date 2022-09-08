package com.bankinformationjobs.domain;


import java.io.Serializable;
import javax.persistence.*;
import lombok.*;
@Entity
@Table(name = "servicios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Servicios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "servicio")
    private String servicio;
}
