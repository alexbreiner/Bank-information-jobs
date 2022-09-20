package com.bankinformationjobs.repository;

import com.bankinformationjobs.domain.entity.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Integer> {

    /**
     *
     * @param ciudad
     * @return Encontrar un profesional por ciudad recidencia
     */
    Optional<Profesional> findProfesionalByCiudad(String ciudad);

    /**
     *
     * @param profesion
     * @return Encontrar un profesional por su profesión
     */
    Optional<Profesional>  findProfesionalByProfesion(String profesion);

    Optional<Profesional> findProfesionalByNombre(String nombre);

    @Query("SELECT P FROM Profesional P WHERE "
            + " CONCAT(P.nombre, P.profesion, P.ciudad, P.telefono, P.apellido, P.barrio, P.direccion, P.correo)"
            + " LIKE %?1%")
     List<Profesional> findAll(@Param("nombreAtributo") String nombreAtributo);

}
