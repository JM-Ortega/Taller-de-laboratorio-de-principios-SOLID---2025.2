package co.unicauca.workflow.degree_project.main;

import co.unicauca.workflow.degree_project.access.Factory;
import co.unicauca.workflow.degree_project.access.IUserRepository;
import co.unicauca.workflow.degree_project.domain.entities.IPasswordHasher;
import co.unicauca.workflow.degree_project.domain.services.Argon2PasswordHasher;
import co.unicauca.workflow.degree_project.domain.services.IRegistrationService;
import co.unicauca.workflow.degree_project.domain.services.UserService;
import co.unicauca.workflow.degree_project.presentation.GUISignUp;
import co.unicauca.workflow.degree_project.presentation.GUISignIn;
import javax.swing.JFrame;

public class Degree_project {
    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUISignIn ventana = new GUISignIn();
                ventana.setVisible(true);
                ventana.setLocationRelativeTo(null); // Centra la ventana
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la app al cerrar la ventana
            }
        }); 
        
        /*
        javax.swing.SwingUtilities.invokeLater(() -> {
            IUserRepository repo   = Factory.getInstance().getRepository("default");
            IPasswordHasher hasher = new Argon2PasswordHasher();
            IRegistrationService regSvc  = new UserService(repo, hasher);

            GUISignUp ventana = new GUISignUp(regSvc); // inyectamos el servicio
            ventana.setLocationRelativeTo(null);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setVisible(true);
        });
        */
    }
}
