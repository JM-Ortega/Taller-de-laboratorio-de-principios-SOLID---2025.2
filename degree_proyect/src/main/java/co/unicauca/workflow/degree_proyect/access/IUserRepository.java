package co.unicauca.workflow.degree_proyect.access;

import co.unicauca.workflow.degree_proyect.domain.entities.User;

public interface IUserRepository {
    boolean save(User newUser);
    
    String getRol(String email, String password);
    
    String getPassword(String email);
}
