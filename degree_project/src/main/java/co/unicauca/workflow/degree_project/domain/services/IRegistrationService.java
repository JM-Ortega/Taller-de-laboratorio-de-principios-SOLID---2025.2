/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.workflow.degree_project.domain.services;

import co.unicauca.workflow.degree_project.presentation.dtos.RegisterUserDTO;

/**
 *
 * @author Ortega
 */
public interface IRegistrationService {

    RegistrationResult register(RegisterUserDTO dto);
}
