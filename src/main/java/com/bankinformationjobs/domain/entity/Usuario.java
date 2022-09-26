// package com.bankinformationjobs.domain.entity;

// import javax.persistence.*;
// import javax.validation.Valid;
// import javax.validation.constraints.*;
// import java.io.Serializable;

// import lombok.*;

// @Entity
// @Table(name = "usuario")
// @AllArgsConstructor
// @NoArgsConstructor
// @Getter
// @Setter
// @ToString
// public class Usuario implements Serializable {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id_usuario", nullable = false, unique = false)
//     private Integer idUsuario;

//     @Min(1)
//     @Max(225)
//     @Column(name = "nombre")
//     private String nombre;

//     @Min(1)
//     @Max(225)
//     @Column(name = "apellido")
//     private String apellido;

//     @Min(1)
//     @Max(10)
//     @Column(name = "telefono")
//     private int telefono;

//     @NotBlank()
//     @Valid()
//     @Pattern(regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$")
//     @Column(name = "correo")
//     private String correo;

//     @Column(name = "ciudad")
//     private String ciudad;

//     @Min(5)
//     @Max(225)
//     @Column(name = "barrio")
//     private String barrio;

//     @Min(5)
//     @Max(225)
//     @Column(name = "direccion")
//     private String direccion;

// }
