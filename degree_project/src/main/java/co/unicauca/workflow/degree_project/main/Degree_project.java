package co.unicauca.workflow.degree_project.main;

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
    }
}
