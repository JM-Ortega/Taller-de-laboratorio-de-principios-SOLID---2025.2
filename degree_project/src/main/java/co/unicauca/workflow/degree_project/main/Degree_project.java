package co.unicauca.workflow.degree_project.main;

import co.unicauca.workflow.degree_project.access.IUserRepository;
import co.unicauca.workflow.degree_project.access.SqliteRepository;
import co.unicauca.workflow.degree_project.domain.entities.IPasswordHasher;
import co.unicauca.workflow.degree_project.domain.services.Argon2PasswordHasher;
import co.unicauca.workflow.degree_project.domain.services.IRegistrationService;
import co.unicauca.workflow.degree_project.domain.services.UserService;
import co.unicauca.workflow.degree_project.presentation.GUISignIn;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import co.unicauca.workflow.degree_project.domain.services.ISignInService;

public class Degree_project {

    public static void main(String[] args) {

        IUserRepository repo = new SqliteRepository();
        IPasswordHasher hasher = new Argon2PasswordHasher();
        
        
        UserService userService = new UserService(repo, hasher);
        
        
        ISignInService loginService = userService;
        
        IRegistrationService registrationService = userService;

        SwingUtilities.invokeLater(() -> {
            GUISignIn ventana = new GUISignIn(loginService, registrationService);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
