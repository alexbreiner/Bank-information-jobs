package com.bankinformationjobs.domain;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;


@Entity
@Table(name = "comentarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comentarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer idComentario;

    @ManyToOne
    @JoinColumn(name = "id_profesional")
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "calificacion")
    private int calificacion;

    @Column(name = "comentario")
    private String comentario;
}
