package com.bankinformationjobs.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import lombok.*;



@Entity
@Table(name = "comentarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="profesional_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Profesional profesional;

    @Min(1)
    @Max(5)
    @Column(name = "calificacion")
    private int calificacion;

    @Max(255)
    @Column(name = "comentario")
    private String comentario;
}
