/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.unicauca.workflow.degree_project.domain.services;

import co.unicauca.workflow.degree_project.access.IUserRepository;
import co.unicauca.workflow.degree_project.domain.entities.IPasswordHasher;
import co.unicauca.workflow.degree_project.domain.entities.Programa;
import co.unicauca.workflow.degree_project.domain.entities.Rol;
import co.unicauca.workflow.degree_project.domain.entities.User;
import co.unicauca.workflow.degree_project.presentation.dtos.RegisterUserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

/**
 *
 * @author Ortega
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    IUserRepository repo;
    @Mock
    IPasswordHasher hasher;

    private UserService service;

    @BeforeEach
    void setup() {
        service = new UserService(repo, hasher);
    }

    // -------------------- Helpers --------------------
    private static Programa anyPrograma() {
        return Programa.values()[0];
    }

    private static Rol anyRol() {
        return Rol.values()[0];
    }

    private static RegisterUserDTO makeValidDto() {
        RegisterUserDTO dto = new RegisterUserDTO();
        dto.setNombres(" Juan ");
        dto.setApellidos(" Pérez ");
        dto.setEmail("Juan.Perez@UNICAUCA.edu.co"); // debe normalizarse a lowercase
        dto.setPassword("Abcd1!x");                  // >=6, dígito, mayúscula, especial
        dto.setPrograma(anyPrograma());
        dto.setRol(anyRol());
        dto.setCelular(null);                        // opcional (GUI lo manda null si vacío)
        return dto;
    }

    // -------------------- Tests --------------------
    @Test
    void register_nullDto_returnsFail() {
        var res = service.register(null);

        assertFalse(res.ok());
        assertEquals("Datos de registro vacíos", res.message());
        assertTrue(res.fieldErrors() == null || res.fieldErrors().isEmpty());
        assertNull(res.userId());
        verifyNoInteractions(repo, hasher);
    }

    @Test
    void register_validationErrors_prioritizedAndAggregated() {
        // nombres vacío (NotBlank)
        // email vacío (NotBlank tiene prioridad sobre Email/Pattern)
        // password corta (Size prioridad sobre Pattern)
        // celular 9 dígitos (Pattern)
        RegisterUserDTO dto = new RegisterUserDTO();
        dto.setNombres("");
        dto.setApellidos("Alvarez");
        dto.setEmail("");
        dto.setPassword("A1!");
        dto.setPrograma(anyPrograma());
        dto.setRol(anyRol());
        dto.setCelular("123456789");

        var res = service.register(dto);

        assertFalse(res.ok());
        assertEquals("Errores de validación", res.message());
        assertNull(res.userId());

        Map<String, String> fe = res.fieldErrors();
        assertNotNull(fe);

        assertTrue(fe.containsKey("nombres"));
        assertTrue(fe.get("nombres").toLowerCase().contains("obligatorio"));

        assertTrue(fe.containsKey("email"));
        assertTrue(fe.get("email").toLowerCase().contains("obligatorio"));

        assertTrue(fe.containsKey("password"));
        assertTrue(fe.get("password").toLowerCase().contains("al menos 6"));

        assertTrue(fe.containsKey("celular"));
        assertTrue(fe.get("celular").toLowerCase().contains("10"));

        verifyNoInteractions(repo, hasher);
    }

    @Test
    void register_fail_emailDuplicado() {
        var dto = makeValidDto();
        // El servicio normaliza a lowercase y trim
        when(repo.existsByEmail("juan.perez@unicauca.edu.co")).thenReturn(true);

        var res = service.register(dto);

        assertFalse(res.ok());
        assertEquals("El email ya está registrado.", res.message());
        assertNull(res.userId());
        assertEquals("El email ya está registrado.", res.fieldErrors().get("email"));

        verify(repo).existsByEmail("juan.perez@unicauca.edu.co");
        verify(hasher, never()).hash(any());
        verify(repo, never()).save(any());
    }

    @Test
    void register_success_mapsHashesAndLowercasesEmail() {
        var dto = makeValidDto();

        when(repo.existsByEmail("juan.perez@unicauca.edu.co")).thenReturn(false);
        when(hasher.hash(dto.getPassword().toCharArray())).thenReturn("$argon2id$...");
        ArgumentCaptor<User> userCap = ArgumentCaptor.forClass(User.class);
        when(repo.save(userCap.capture())).thenReturn(true);

        var res = service.register(dto);

        assertTrue(res.ok());
        assertEquals("OK", res.message());
        assertNotNull(res.userId());

        User saved = userCap.getValue();
        assertNotNull(saved);
        assertEquals("Juan", saved.getNombres().trim());
        assertEquals("Pérez", saved.getApellidos().trim());
        assertNull(saved.getCelular()); // vino null
        assertEquals(anyPrograma(), saved.getPrograma());
        assertEquals(anyRol(), saved.getRol());
        assertEquals("juan.perez@unicauca.edu.co", saved.getEmail()); // lowercased
        assertEquals("$argon2id$...", saved.getPasswordHash());

        verify(repo).existsByEmail("juan.perez@unicauca.edu.co");
        verify(hasher).hash(dto.getPassword().toCharArray());
        verify(repo).save(any());
        verifyNoMoreInteractions(repo, hasher);
    }

    @Test
    void register_repoSaveReturnsFalse_returnsFail() {
        var dto = makeValidDto();

        when(repo.existsByEmail("juan.perez@unicauca.edu.co")).thenReturn(false);
        when(hasher.hash(dto.getPassword().toCharArray())).thenReturn("HASHED");
        when(repo.save(any())).thenReturn(false);

        var res = service.register(dto);

        assertFalse(res.ok());
        assertEquals("No se pudo guardar el usuario.", res.message());
        assertNull(res.userId());
        assertTrue(res.fieldErrors() == null || res.fieldErrors().isEmpty());

        verify(repo).existsByEmail("juan.perez@unicauca.edu.co");
        verify(hasher).hash(dto.getPassword().toCharArray());
        verify(repo).save(any());
        verifyNoMoreInteractions(repo, hasher);
    }

    @Test
    void register_optionalCelularNull_ok() {
        var dto = makeValidDto();
        dto.setCelular(null); // GUI normaliza vacío/placeholder a null

        when(repo.existsByEmail("juan.perez@unicauca.edu.co")).thenReturn(false);
        when(hasher.hash(dto.getPassword().toCharArray())).thenReturn("HASHED");
        when(repo.save(any())).thenReturn(true);

        var res = service.register(dto);

        assertTrue(res.ok());
        assertEquals("OK", res.message());
        assertNotNull(res.userId());

        verify(repo).existsByEmail("juan.perez@unicauca.edu.co");
        verify(hasher).hash(dto.getPassword().toCharArray());
        verify(repo).save(any());
    }
}
