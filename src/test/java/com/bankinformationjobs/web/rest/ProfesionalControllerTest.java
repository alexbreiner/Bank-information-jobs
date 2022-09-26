package com.bankinformationjobs.web.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.bankinformationjobs.domain.entity.Profesional;
import com.bankinformationjobs.repository.ProfesionalRepository;
import com.bankinformationjobs.service.dto.ProfesionalDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.bankinformationjobs.service.ProfesionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import com.bankinformationjobs.constants.Datos;
import org.springframework.http.MediaType;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.springframework.web.context.WebApplicationContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


//@WebMvcTest(ProfesionalController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProfesionalControllerTest {

    // Permitir acceder o hacer peticiones http
    @Autowired
    private MockMvc mockMvc;
    private WebApplicationContext context;

    private ObjectMapper objectMapper;
    //crear un simulacro a  este objeto
    @MockBean
    private ProfesionalService profesionalService;
    @MockBean
    private ProfesionalRepository profesionalRepository;
    @Autowired
    private ProfesionalRepository profesionalRepositoryMock = Mockito.mock(ProfesionalRepository.class);

    @Autowired
    private ProfesionalController profesionalController;

    @BeforeEach
    public void setup() {

        Profesional mockProfesional = new Profesional();
        mockProfesional.setIdProfesional(1);
        mockProfesional.setNombre("Jesus");
        mockProfesional.setApellido("Hurtado");
        mockProfesional.setProfesion("Chofer");
        mockProfesional.setCiudad("Palmira valle");
        mockProfesional.setCorreo("alex@gmail.com");
        mockProfesional.setTelefono("312998221");
        mockProfesional.setBarrio("independencia");
        mockProfesional.setImageUrl("https://images.pexels.com/photos/1714208/pexels-photo-1714208.jpeg?auto=compress&cs=tinysrgb&w=1600");

        Mockito.when(profesionalRepositoryMock.findProfesionalByIdProfesional(1)).thenReturn(Optional.of(mockProfesional));
        //Mockito.when(profesionalService.getProfesionalById(1)).thenReturn(Optional.of(mockProfesional));

        //mockMvc.perform(post("/professionals").contentType());
    }

    @Test
    public void testProfesionalByNombre() throws Exception {
        String nombre = "Alex";
        when(profesionalService.searchForName(nombre)).thenReturn(Optional.of(Optional.of(new Profesional()).orElseThrow()));
        mockMvc.perform(get("http://localhost:8080/api/profesionals/searchForName").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(302))
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.nombre").value(nombre))
                .andExpect(jsonPath("$.apellido").value("Delgado"))
                .andExpect(jsonPath("$.barrio").value("San pedro"))
                .andExpect(jsonPath("$.direccion").value("calle 50 n 34"))
                .andExpect(jsonPath("$.ciudad").value("Plamira"))
                .andExpect(jsonPath("$.profesion").value("Desarrollador Software"))
                .andExpect(jsonPath("$.correo").value("alex@gmail.com"))
                .andExpect(jsonPath("$.imageUrl").value("https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes-thumbnail.png"));

        verify(profesionalService.searchForName("Alex"));
    }

    @Test
    //@WithUserDetails("alex")
    void testVerProfesionalById() throws Exception {
        //Simulando la creacion de un servicio
        when(profesionalService.getProfesionalById(1)).thenReturn(Optional.of(Datos.crearProfesional1().orElseThrow()));
        //correr la prueba recibe una peticion
        mockMvc.perform(get("http://localhost:8080/api/profesional/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())//que estado de la respuesta sea ok
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //que lleve en tipo JSON
                .andExpect(jsonPath("$.nombre").value("Julian"))
                .andExpect(jsonPath("$.apellido").value("Matinez"))
                .andExpect(jsonPath("$.profesion").value("Peluquero"))
                .andExpect(jsonPath("$.telefono").value("3125548632"))
                .andExpect(jsonPath("$.correo").value("Julian@gmail.com"))
                .andExpect(jsonPath("$.ciudad").value("Palmira"))
                .andExpect(jsonPath("$.barrio").value("San pablo"))
                .andExpect(jsonPath("$.direccion").value("calle 20 #50-55"))
                .andExpect(jsonPath("$.imageUrl").value("https://images.pexels.com/photos/1714208/pexels-photo-1714208.jpeg?auto=compress&cs=tinysrgb&w=1600"))
        ;
        //verificar que encuentre al profesional por id
        verify(profesionalService).getProfesionalById(1);
    }

    @Test
    @AutoConfigureMockMvc
    public void testProfesionalDetailsById() {
        Optional<Profesional> respuestaServicio;
        respuestaServicio =  profesionalController.getProfesionalById(1);
        Assertions.assertEquals("Desarrollador Software", respuestaServicio.filter(profesional -> Boolean.parseBoolean(profesional.getProfesion())));
    }

    @Test
    public void testCrearProfesional()  {
        ProfesionalDto profesionalDto = new ProfesionalDto(0, "Negro", "Hurtado Vidal",
                "Chofer","3125548632", "jesus@gmail.com", "Palmira",
                "independencia", "calle 19",
                "https://images.pexels.com/photos/1714208/pexels-photo-1714208.jpeg?auto=compress&cs=tinysrgb&w=1600");

        ResponseEntity<ProfesionalDto> responseEntity;
        responseEntity = profesionalService.crearProfesional(profesionalDto);
        Assertions.assertEquals("Negro", responseEntity.getBody().getIdProfesional());
    }

    @Test
    public void tesSearchByNameProfessionl() {
        when(profesionalRepository.findProfesionalByNombre("Alex")).thenReturn(Optional.of(Datos.crearProfesional2()).orElseThrow());
        Profesional profesional = new Profesional();

        verify(profesionalRepository).findProfesionalByNombre(profesional.getNombre());
    }

    @Test
    void testSettearDatosProfesional() throws JsonProcessingException {
        ProfesionalDto profesionalDto = new ProfesionalDto();
        profesionalDto.setNombre("Alex");
        profesionalDto.setProfesion("Barbero");
        profesionalDto.setCiudad("Cali");

        System.out.println(objectMapper.writeValueAsString(profesionalDto));

        Map<String, Object> result = new HashMap<>();
    }
}
