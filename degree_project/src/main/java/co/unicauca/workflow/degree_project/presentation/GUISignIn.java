package co.unicauca.workflow.degree_project.presentation;

import co.unicauca.workflow.degree_project.access.Factory;
import co.unicauca.workflow.degree_project.access.IUserRepository;
import co.unicauca.workflow.degree_project.domain.entities.IPasswordHasher;
import co.unicauca.workflow.degree_project.domain.services.Argon2PasswordHasher;
import co.unicauca.workflow.degree_project.domain.services.IRegistrationService;
import co.unicauca.workflow.degree_project.domain.services.IUserService;
import co.unicauca.workflow.degree_project.domain.services.UserService;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GUISignIn extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUISignIn.class.getName());

    public GUISignIn() {
        initComponents();
        this.setLocationRelativeTo(null);
        SwingUtilities.invokeLater(() -> {
            Escudo.requestFocusInWindow();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBackGround = new javax.swing.JPanel();
        Paisaje = new javax.swing.JLabel();
        Escudo = new javax.swing.JLabel();
        lblNoCuenta = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        sepUsuario = new javax.swing.JSeparator();
        lblConrtaseña = new javax.swing.JLabel();
        txtConrtaseña = new javax.swing.JPasswordField();
        sepContraseña = new javax.swing.JSeparator();
        BotonIngresar = new javax.swing.JPanel();
        lblBotonIngresar = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblRegistrarse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jBackGround.setBackground(new java.awt.Color(255, 255, 255));
        jBackGround.setPreferredSize(new java.awt.Dimension(800, 500));
        jBackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Paisaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Paisaje Azul.jpg"))); // NOI18N
        jBackGround.add(Paisaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 500));

        Escudo.setFont(new java.awt.Font("Roboto SemiCondensed", 1, 14)); // NOI18N
        Escudo.setForeground(new java.awt.Color(0, 51, 204));
        Escudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Escudo Unicauca.png"))); // NOI18N
        Escudo.setToolTipText("");
        jBackGround.add(Escudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 70, 110));

        lblNoCuenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblNoCuenta.setText("¿Aun no tienes una cuenta?");
        jBackGround.add(lblNoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 150, -1));

        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(102, 102, 102));
        txtCorreo.setText("Ingrese su correo institucional");
        txtCorreo.setBorder(null);
        txtCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCorreoMousePressed(evt);
            }
        });
        jBackGround.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 290, 20));

        sepUsuario.setBackground(new java.awt.Color(255, 255, 255));
        sepUsuario.setForeground(new java.awt.Color(0, 102, 204));
        sepUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sepUsuario.setPreferredSize(new java.awt.Dimension(270, 10));
        jBackGround.add(sepUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, -1, -1));

        lblConrtaseña.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblConrtaseña.setText("CONTRASEÑA");
        jBackGround.add(lblConrtaseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 130, -1));

        txtConrtaseña.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtConrtaseña.setForeground(new java.awt.Color(102, 102, 102));
        txtConrtaseña.setText("**********");
        txtConrtaseña.setBorder(null);
        txtConrtaseña.setPreferredSize(new java.awt.Dimension(270, 20));
        txtConrtaseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtConrtaseñaMousePressed(evt);
            }
        });
        jBackGround.add(txtConrtaseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 270, 20));

        sepContraseña.setBackground(new java.awt.Color(255, 255, 255));
        sepContraseña.setForeground(new java.awt.Color(0, 102, 204));
        sepContraseña.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sepContraseña.setPreferredSize(new java.awt.Dimension(270, 10));
        jBackGround.add(sepContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        BotonIngresar.setBackground(new java.awt.Color(0, 102, 204));

        lblBotonIngresar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblBotonIngresar.setForeground(new java.awt.Color(255, 255, 255));
        lblBotonIngresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonIngresar.setText("Ingresar");
        lblBotonIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBotonIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //lblBotonIngresarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BotonIngresarLayout = new javax.swing.GroupLayout(BotonIngresar);
        BotonIngresar.setLayout(BotonIngresarLayout);
        BotonIngresarLayout.setHorizontalGroup(
            BotonIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBotonIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        BotonIngresarLayout.setVerticalGroup(
            BotonIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonIngresarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblBotonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jBackGround.add(BotonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 120, 40));

        lblUsuario.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblUsuario.setText("USUARIO");
        jBackGround.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 80, -1));

        lblRegistrarse.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblRegistrarse.setText("Create una");
        lblRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //lblRegistrarseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRegistrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegistrarseMouseExited(evt);
            }
        });
        jBackGround.add(lblRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarseMouseEntered
        lblRegistrarse.setForeground(Color.BLUE);
        lblRegistrarse.setFont(new Font("Roboto", Font.BOLD, 12));
    }//GEN-LAST:event_lblRegistrarseMouseEntered

    private void lblRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarseMouseExited
        lblRegistrarse.setForeground(Color.BLACK);
        lblRegistrarse.setFont(new Font("Roboto", Font.PLAIN, 12));
    }//GEN-LAST:event_lblRegistrarseMouseExited

    private void txtCorreoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoMousePressed
        if(txtCorreo.getText().equals("Ingrese su correo institucional")){
            txtCorreo.setText("");
            txtCorreo.setForeground(Color.black);
        }
        if(String.valueOf(txtConrtaseña.getPassword()).isEmpty()){
            txtConrtaseña.setText("**********");
            txtConrtaseña.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtCorreoMousePressed

    private void txtConrtaseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConrtaseñaMousePressed
        if(String.valueOf(txtConrtaseña.getPassword()).equals("**********")){
            txtConrtaseña.setText("");
            txtConrtaseña.setForeground(Color.black);
        }
        if(txtCorreo.getText().isEmpty()){
            txtCorreo.setText("Ingrese su correo institucional");
            txtCorreo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtConrtaseñaMousePressed

    // Método para validar JTextField
    private boolean esCampoInvalido(JTextField campo, String placeholder) {
        return campo.getText().trim().isEmpty() || campo.getText().equals(placeholder);
    }

    // Método para validar JPasswordField
    private boolean esCampoInvalido(JPasswordField campo, String placeholder) {
        String texto = String.valueOf(campo.getPassword());
        return texto.trim().isEmpty() || texto.equals(placeholder);
    }
    
    private void lblBotonIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonIngresarMouseClicked
        String usuario = txtCorreo.getText();
        char[] passwordIngresada = txtConrtaseña.getPassword();
        
        IUserRepository repository = Factory.getInstance().getRepository("default");
        IUserService service = new UserService(repository);
        
        if (esCampoInvalido(txtCorreo, "Ingrese su correo institucional") ||
            esCampoInvalido(txtConrtaseña, "**********")){
            JOptionPane.showMessageDialog(
                null,
                "Por favor, rellene todos los campos.",
                "Campos incompletos",
                JOptionPane.WARNING_MESSAGE
            );
        }else{
            service.validacion(usuario, passwordIngresada);
        }        
    }//GEN-LAST:event_lblBotonIngresarMouseClicked

    private void lblRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarseMouseClicked
        IUserRepository repo   = Factory.getInstance().getRepository("default");
        IPasswordHasher hasher = new Argon2PasswordHasher();
        IRegistrationService regSvc  = new UserService(repo, hasher);
        GUISignUp ventana = new GUISignUp(regSvc); // inyectamos el servicio
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblRegistrarseMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GUISignIn().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonIngresar;
    private javax.swing.JLabel Escudo;
    private javax.swing.JLabel Paisaje;
    private javax.swing.JPanel jBackGround;
    private javax.swing.JLabel lblBotonIngresar;
    private javax.swing.JLabel lblConrtaseña;
    private javax.swing.JLabel lblNoCuenta;
    private javax.swing.JLabel lblRegistrarse;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JSeparator sepContraseña;
    private javax.swing.JSeparator sepUsuario;
    private javax.swing.JPasswordField txtConrtaseña;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
