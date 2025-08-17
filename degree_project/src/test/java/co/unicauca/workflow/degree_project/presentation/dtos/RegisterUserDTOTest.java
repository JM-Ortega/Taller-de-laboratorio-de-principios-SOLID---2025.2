package co.unicauca.workflow.degree_project.presentation.dtos;

import co.unicauca.workflow.degree_project.domain.entities.Programa;
import co.unicauca.workflow.degree_project.domain.entities.Rol;
import jakarta.validation.*;
import org.junit.jupiter.api.*;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserDTOTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    static void initValidator() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterAll
    static void closeValidatorFactory() {
        if (factory != null) {
            factory.close();
        }
    }

    private RegisterUserDTO valido() {
        RegisterUserDTO dto = new RegisterUserDTO();
        dto.setNombres("Juan");
        dto.setApellidos("Ortega");
        dto.setCelular("3121234567");
        dto.setPrograma(Programa.Ingenieria_de_Sistemas);
        dto.setRol(Rol.Estudiante);
        dto.setEmail("juan@unicauca.edu.co");
        dto.setPassword("Passw0rd!");
        return dto;
    }

    private static Set<String> campos(Set<? extends ConstraintViolation<?>> v) {
        return v.stream()
                .map(cv -> cv.getPropertyPath().toString())
                .collect(Collectors.toSet());
    }

    @Test
    void dtoValidoDebePasar() {
        var violaciones = validator.validate(valido());
        assertTrue(violaciones.isEmpty(), () -> "Violaciones: " + violaciones);
    }

    @Test
    void emailDebeSerDominioUnicauca() {
        var dto = valido();
        dto.setEmail("juan@gmail.com"); // inválido
        var violaciones = validator.validate(dto);
        assertFalse(violaciones.isEmpty());
        assertTrue(campos(violaciones).contains("email"));
    }

    @Test
    void passwordDebeSerFuerte() {
        var dto = valido();
        dto.setPassword("Abcdef"); // sin dígito ni especial
        var violaciones = validator.validate(dto);
        assertFalse(violaciones.isEmpty());
        assertTrue(campos(violaciones).contains("password"));
    }

    @Test
    void passwordDebeTenerMinimoSeisCaracteres() {
        var dto = valido();
        dto.setPassword("A1!"); // muy corta
        var violaciones = validator.validate(dto);
        assertFalse(violaciones.isEmpty());
        assertTrue(campos(violaciones).contains("password"));
    }

    @Test
    void celularDebeTenerDiezDigitos() {
        var dto = valido();
        dto.setCelular("12345"); // inválido
        var violaciones = validator.validate(dto);
        assertFalse(violaciones.isEmpty());
        assertTrue(campos(violaciones).contains("celular"));
    }

    @Test
    void programaNoPuedeSerNull() {
        var dto = valido();
        dto.setPrograma(null);
        var v = validator.validate(dto);
        assertFalse(v.isEmpty());
        assertTrue(campos(v).contains("programa"));
    }

    @Test
    void rolNoPuedeSerNull() {
        var dto = valido();
        dto.setRol(null);
        var v = validator.validate(dto);
        assertFalse(v.isEmpty());
        assertTrue(campos(v).contains("rol"));
    }

}
