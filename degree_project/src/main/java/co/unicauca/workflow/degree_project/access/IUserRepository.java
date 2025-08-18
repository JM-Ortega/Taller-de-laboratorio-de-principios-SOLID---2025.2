package co.unicauca.workflow.degree_project.access;

import co.unicauca.workflow.degree_project.domain.entities.User;

public interface IUserRepository {
    boolean save(User newUser);
    
    String getRol(String email, char[] passwordIngresada);
    
    String getPassword(String email);
    
    boolean validarIngrereso(String email, char[] passwordIngresada);
}
