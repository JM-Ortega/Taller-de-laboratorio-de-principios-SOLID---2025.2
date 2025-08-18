/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package co.unicauca.workflow.degree_project.domain.entities;

/**
 *
 * @author Ortega
 */
public enum Rol {
    Estudiante("Estudiante"),
    Docente("Docente");
    
    private final String displayName;
    
    Rol(String displayName) { 
        this.displayName = displayName; }
    
    
    @Override
    public String toString() {
        return displayName;
    }
}
