package co.unicauca.workflow.degree_project.domain.services;

public interface IUserService {
    boolean validarSesion(String email, char[] passwordIngresada);
    String getRol(String email, char[] passwordIngresada);
    void validacion(String usuario, char[] passwordIngresada);
}
