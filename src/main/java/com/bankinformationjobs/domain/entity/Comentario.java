package com.bankinformationjobs.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    @ManyToOne
    @JoinColumn(name = "id_profesional")
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Min(1)
    @Max(5)
    @Column(name = "calificacion")
    private int calificacion;

    @Max(255)
    @Column(name = "comentario")
    private String comentario;
}
