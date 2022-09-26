package com.bankinformationjobs.domain.entity;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.bankinformationjobs.repository.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.annotation.Rollback;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.util.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.class)
public class ProfesionalTests {

    @Autowired
    private ProfesionalRepository profesionalRepository;

     @Test()
     @Rollback(value = false)
     @Order(1)
     public void testGuardarProfesional() {

         Profesional profesional = new Profesional(0,"Jesus", "Hurtado",
                 "Chofer","3125548632", "jesus@gmail.com", "palmira",
                 "parque amor", "calle 19",
                 "https://images.pexels.com/photos/1714208/pexels-photo-1714208.jpeg?auto=compress&cs=tinysrgb&w=1600");

        Profesional professionalSave = profesionalRepository.save(profesional);

        assertNotNull(professionalSave);

     }

    @Test
    @Order(2)
    public void testBuscarProfesionalPorNombre() {
        String nombre = "Jesus";

        Optional<Profesional> profesional = profesionalRepository.findProfesionalByNombre(nombre);

        assertThat(profesional.get().getNombre()).isEqualTo(nombre);
    }

    @Test
    @Order(3)
    public void testBuscarProfesionalPorProfesion() {
        String profesion = "Desarrollador Software";

        Optional<Profesional> profesional = profesionalRepository.findProfesionalByProfesion(profesion);
        //validar que sea exactamente el nombre
        assertThat(profesional.get().getProfesion()).isEqualTo(profesion);

    }

    @Test
    @Order(4)
    public void testBuscarProfesionalPorNombreNoExistente() {
        String nombre = "Miguel";

        Optional<Profesional> profesional = profesionalRepository.findProfesionalByNombre(nombre);

        //preguntar si no existe si es null true
        assertNull(profesional);
    }

    @Test()
    @Order(5)
    @Rollback(value = false)
    public void testActualizarProfesional() {

        final String nombreProfesional = "Jesus Miguel";
        final int id = 18;

         Profesional profesional = new Profesional(0, nombreProfesional, "Hurtado Vidal",
                 "Chofer","3125548632", "jesus@gmail.com", "Palmira",
                 "independencia", "calle 19",
                 "https://images.pexels.com/photos/1714208/pexels-photo-1714208.jpeg?auto=compress&cs=tinysrgb&w=1600"); //valores nuevo

         profesional.setId(id);

         profesionalRepository.save(profesional);

         Optional<Profesional> profesionalActualizado = profesionalRepository.findProfesionalByNombre(nombreProfesional);

         assertThat(profesionalActualizado.get().getNombre()).isEqualTo(nombreProfesional);

    }

    @Test
    @Order(6)
    public void testListarProfesionales() {
        List<Profesional> profesionals = profesionalRepository.findAll();
        //comprobar si es mayor a 0
        for (Profesional profesional : profesionals) {
            System.out.println("list of profesionales" + profesional);
        }
        assertThat(profesionals).size().isGreaterThan(0);
    }

    @Test
    @Rollback(value = false)
    @Order(7)
    public void testEliminarProductos() {

        Integer id = 22;

        boolean isExistAfterOfDelete = profesionalRepository.findById(id).isPresent(); //preguntar si esta presente

        profesionalRepository.deleteById(id);

        boolean isNotExistAfterOfDelete = profesionalRepository.findById(id).isPresent(); //preguntar si no esta presente

        //validar valores booleanos
        assertTrue(isExistAfterOfDelete);
        assertFalse(isNotExistAfterOfDelete);
    }
}
