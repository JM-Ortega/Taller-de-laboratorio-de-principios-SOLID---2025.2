package co.unicauca.workflow.degree_proyect.domain.services;

import co.unicauca.workflow.degree_proyect.domain.entities.Programa;
import co.unicauca.workflow.degree_proyect.domain.entities.Rol;
import co.unicauca.workflow.degree_proyect.domain.entities.User;
import java.util.Scanner;
import co.unicauca.workflow.degree_proyect.access.IUserRepository;

public class UserService {
    Scanner scanner = new Scanner(System.in);
    PasswordHasher passwordHasher = new PasswordHasher();
    
    private IUserRepository repository;
    
    public UserService(IUserRepository repository) {
        this.repository = repository;
    }
    
    
}
