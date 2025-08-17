package co.unicauca.workflow.degree_proyect.domain.entities;

public class User {
    
    private String nombre;
    private String apellidos;
    private Programa programa;
    private String email;
    private String celular;
    private Rol rol;
    private String contraseña;
    
    public User(String nombre, String apellidos, Programa programa, String email, String celular, Rol rol, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.programa = programa;
        this.email = email;
        this.celular = celular;
        this.rol = rol;
        this.contraseña = contraseña;
    }

    public User() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Nombre: " +nombre+ "\nApellido: " +apellidos+ "\nPrograma: " +programa+ "\nEmail: " +email+ "\nCelular: " +celular+ "\nRol: " +rol+ "\nContrasena: " +contraseña +"\n\n";
    }
    
}
