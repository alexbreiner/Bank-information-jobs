package com.bankinformationjobs.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @Column(name = "id_comentario" , nullable = false, unique = true)
    private Integer idComentario;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_usuario")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario usuario;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profesional", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Profesional profesional;

    @Min(1)
    @Max(5)
    @Column(name = "calificacion")
    private int calificacion;

    @Max(255)
    @Column(name = "comentario")
    private String comentario;

    
}
