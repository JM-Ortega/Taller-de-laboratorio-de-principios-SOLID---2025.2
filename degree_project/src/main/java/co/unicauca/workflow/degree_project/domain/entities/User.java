package co.unicauca.workflow.degree_project.domain.entities;

public class User {
    
    private String id;
    private String nombres;
    private String apellidos;
    private String celular;
    private Programa programa;
    private Rol rol;
    private String email;
    private String passwordHash;

    public User(String id, String nombres, String apellidos, String celular, Programa programa, Rol rol, String email, String passwordHash) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.programa = programa;
        this.rol = rol;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    @Override
    public String toString() {
        return "Nombre: " +nombres+ "\nApellido: " +apellidos+ "\nPrograma: " +programa+ "\nEmail: " +email+ "\nCelular: " +celular+ "\nRol: " +rol+ "\nContrasena: " +passwordHash +"\n\n";
    }
}
