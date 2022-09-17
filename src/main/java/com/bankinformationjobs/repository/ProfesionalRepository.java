package com.bankinformationjobs.repository;

import com.bankinformationjobs.domain.entity.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

}
