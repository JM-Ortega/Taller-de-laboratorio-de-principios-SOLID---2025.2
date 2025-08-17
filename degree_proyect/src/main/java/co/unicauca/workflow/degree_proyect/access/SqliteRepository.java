package co.unicauca.workflow.degree_proyect.access;

import co.unicauca.workflow.degree_proyect.domain.entities.User;
import co.unicauca.workflow.degree_proyect.domain.services.UserService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteRepository implements IUserRepository{
    private Connection conn;
    
    public SqliteRepository(){
        initDatabase();
    }
    
    private void initDatabase(){
        String sql1 = "CREATE TABLE IF NOT EXISTS Rol (\n"
                + "idRol integer PRIMARY KEY,\n"
                + "tipo text NOT NULL UNIQUE"
                +");";
        
        String sql2 = "CREATE TABLE IF NOT EXISTS Programa (\n"
                + "idPrograma integer PRIMARY KEY,\n"
                + "tipo text NOT NULL UNIQUE"
                +");";
        
        String sql3 = "INSERT OR IGNORE INTO Rol(tipo) VALUES ('Estudiante'), ('Docente');\n";
                
        String sql4 = "INSERT OR IGNORE INTO Programa(tipo) VALUES ('Ingenieria_de_Sistemas'), ('Ingenieria_Electronica_y_Telecomunicaciones'), ('Automatica_Industrial'), ('Tecnologia_en_Telematica');\n";
    
        String sql5 = "CREATE TABLE IF NOT EXISTS User (\n"
                + "nombre text NOT NULL,\n"
                + "apellidos text NOT NULL, \n"
                + "idPrograma integer NOT NULL, \n"
                + "email text NOT NULL,"
                + "celular text, \n"
                + "idRol integer NOT NULL, \n"
                + "contraseña text NOT NULL, \n"
                + "PRIMARY KEY (email, contraseña), \n"
                + "FOREIGN KEY (idRol) REFERENCES Rol(idRol), \n"
                + "FOREIGN KEY (idPrograma) REFERENCES Programa(idPrograma)\n"
                +");";
        
        try{
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql1);
            stmt.execute(sql2);
            stmt.execute(sql3);
            stmt.execute(sql4);
            stmt.execute(sql5);
        }catch(SQLException ex){
              Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);      
        }
    }
    
    public void connect(){
        String url = "jdbc:sqlite::memory:";
        
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public boolean save(User newUser) {
        try{
            if (newUser == null
            || newUser.getEmail() == null || newUser.getEmail().isBlank()
            || !newUser.getEmail().endsWith("@unicauca.edu.co")
            || newUser.getNombre() == null || newUser.getNombre().isBlank()
            || newUser.getApellidos() == null || newUser.getApellidos().isBlank()
            || newUser.getPrograma() == null
            || newUser.getRol() == null
            || newUser.getContraseña() == null || newUser.getContraseña().isBlank())
            { 
                return false;
            }
            String sql = "INSERT INTO User ( nombre, apellidos, idPrograma,  email, celular, idRol, contraseña) "
                    + "VALUES ( ?, ?, ? , ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getNombre());
            pstmt.setString(2, newUser.getApellidos());
            pstmt.setInt(3, newUser.getPrograma().ordinal()+1);
            pstmt.setString(4, newUser.getEmail());
            pstmt.setString(5, newUser.getCelular());
            pstmt.setInt(6, newUser.getRol().ordinal()+1);
            pstmt.setString(7, newUser.getContraseña());
            pstmt.executeUpdate();
            
            return true;
        }catch(SQLException ex){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public String getRol(String email, String password) {
        String rol = null;
        String sql = "SELECT Rol.tipo "
                + "FROM User "
                + "INNER JOIN Rol ON User.idRol = Rol.idRol "
                + "WHERE User.email = ? AND User.contraseña = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                rol = rs.getString("tipo");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rol;
    }

    @Override
    public String getPassword(String email) {
        String password = null;
        String sql = "SELECT contraseña "
                + "FROM User "
                + "WHERE User.email = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                password = rs.getString("contraseña");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return password;
    }
}
