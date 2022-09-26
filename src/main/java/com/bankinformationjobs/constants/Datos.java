package com.bankinformationjobs.constants;

import com.bankinformationjobs.domain.entity.Profesional;

import java.util.Optional;

public class Datos {
    public static Optional<Profesional> crearProfesional1() {
        return Optional.of(new Profesional(0,"Julian", "Matinez",
                "Peluquero","3125548632", "Julian@gmail.com", "Palmira",
                "San pablo", "calle 20 #50-55",
                "https://images.pexels.com/photos/1714208/pexels-photo-1714208.jpeg?auto=compress&cs=tinysrgb&w=1600"));
    }

    public static Optional<Profesional> crearProfesional2() {
        return Optional.of(new Profesional(0,"Nico", "Hurtado",
                "Chofer","3125548632", "nico@gmail.com", "Palmira",
                "pablo", "calle 20 #50-55",
                "https://images.pexels.com/photos/1714208/pexels-photo-1714208.jpeg?auto=compress&cs=tinysrgb&w=1600"));
    }

    public static Optional<Profesional> crearProfesional3() {
        return Optional.of(new Profesional(0,"Nico", "Hurtado",
                "Estilista","3125548632", "nico@gmail.com", "Palmira",
                "San pablo", "calle 20 #50-55",
                "https://images.pexels.com/photos/1714208/pexels-photo-1714208.jpeg?auto=compress&cs=tinysrgb&w=1600"));
    }
}
