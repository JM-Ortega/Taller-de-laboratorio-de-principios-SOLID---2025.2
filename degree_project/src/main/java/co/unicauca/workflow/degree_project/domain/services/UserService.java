package co.unicauca.workflow.degree_project.domain.services;

import co.unicauca.workflow.degree_project.access.IUserRepository;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class UserService implements IUserService{
    
    private IUserRepository repository;
    
    public UserService(IUserRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public boolean validarSesion(String email, char[] passwordIngresada){
        boolean flag = repository.validarIngrereso(email, passwordIngresada);
        return flag;
    } 
    
    @Override
    public String getRol(String email, char[] passwordIngresada){
        String rol = repository.getRol(email, passwordIngresada);
        return rol;
    }
    
    @Override
    public void validacion(String usuario, char[] passwordIngresada){   
        //Toca pq despues de usar verify se me borra el array
        char[] copia = Arrays.copyOf(passwordIngresada, passwordIngresada.length);

        boolean flag = validarSesion(usuario, passwordIngresada);
        if(!flag){
            JOptionPane.showMessageDialog(
                null,
                "No fue posible ingresar, usuario o contraseña incorrectos.",
                "Credenciales invalidas",
                JOptionPane.WARNING_MESSAGE
            );
        }else{              
            switch (getRol(usuario, copia)) {
                case "Estudiante":
                    JOptionPane.showMessageDialog(
                        null,
                        "Inicio de sesión como estudiante exitoso.",
                        "Correcto",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    break;
                case "Docente":
                    JOptionPane.showMessageDialog(
                        null,
                        "Inicio de sesión como docente exitoso.",
                        "Correcto",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El usuario no tiene un rol asociado", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
}
