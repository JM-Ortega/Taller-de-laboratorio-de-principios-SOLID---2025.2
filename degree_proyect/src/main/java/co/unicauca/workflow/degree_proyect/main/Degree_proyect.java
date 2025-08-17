package co.unicauca.workflow.degree_proyect.main;

import co.unicauca.workflow.degree_proyect.domain.services.UserService;
import co.unicauca.workflow.degree_proyect.access.Factory;
import co.unicauca.workflow.degree_proyect.access.IUserRepository;

public class Degree_proyect {

    public static void main(String[] args) {
        IUserRepository repository = Factory.getInstance().getRepository("default");
        UserService service = new UserService(repository);
        
    }
}
