/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.unicauca.workflow.degree_project.main;

import co.unicauca.workflow.degree_project.presentation.dtos.RegisterUserDTO;
import jakarta.validation.*;
import java.util.*;
/**
 *
 * @author Ortega
 */
public class Degree_project {

    public static void main(String[] args) {
        
        
            ValidatorFactory f = Validation.buildDefaultValidatorFactory();
    Validator validator = f.getValidator();

    RegisterUserDTO dto = new RegisterUserDTO();
    dto.setNombres("");                      // inválido
    dto.setApellidos("");
    dto.setCelular("123");                   // no 10 dígitos
    dto.setEmail("juan@unicauca.edu.co");          // no @unicauca.edu.co
    dto.setPassword("abc");                  // no cumple reglas

    Set<ConstraintViolation<RegisterUserDTO>> errs = validator.validate(dto);
    errs.forEach(e -> System.out.println(e.getPropertyPath()+": "+e.getMessage()));
    }
}
