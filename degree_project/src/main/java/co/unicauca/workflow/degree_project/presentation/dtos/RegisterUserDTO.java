/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.workflow.degree_project.presentation.dtos;

import co.unicauca.workflow.degree_project.domain.entities.Programa;
import co.unicauca.workflow.degree_project.domain.entities.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author Ortega
 */
public class RegisterUserDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellidos;

    @Pattern(regexp = "\\d{10}", message = "Si ingresas celular, debe tener 10 dígitos")
    private String celular;

    @NotNull(message = "El programa es obligatorio")
    private Programa programa;

    @NotNull(message = "El rol es obligatorio")
    private Rol rol;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email no es válido")
    @Pattern(
            regexp = "(?i)^[A-Za-z0-9._%+-]+@unicauca\\.edu\\.co$",
            message = "El correo debe ser de la Universidad del Cauca (@unicauca.edu.co)"
    )
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!¿?*._-]).{6,}$",
            message = "La contraseña debe tener al menos un dígito, una mayúscula y un carácter especial"
    )
    private String password;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
