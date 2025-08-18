/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package co.unicauca.workflow.degree_project.domain.entities;

/**
 *
 * @author Ortega
 */
public enum Programa {
    Ingenieria_de_Sistemas("Ingeniería de Sistemas"),
    Ingenieria_Electronica_y_Telecomunicaciones("Ingeniería Electrónica y Telecomunicaciones"),
    Automatica_Industrial("Automática Industrial"),
    Tecnologia_en_Telematica("Tecnología en Telemática");

    private final String displayName;

    Programa(String displayName) {
        this.displayName = displayName;
    }
    

    @Override
    public String toString() {
        return displayName;
    }
}