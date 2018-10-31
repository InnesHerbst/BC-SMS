/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UILayer;

import BusinessLayer.Admin;
import BusinessLayer.IAdmin;
import BusinessLayer.IStaff;
import BusinessLayer.Staff;
import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Innes Herbst
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    private final Color cmbBorder;
    private final Border txtBorder;

    private static final String[] arrPosition = {"--Please Select--", "Administrator", "Staff Member"};
    private IStaff staff;
    private IAdmin admin;

    public LoginForm() throws RemoteException, NotBoundException {

        initComponents();
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        staff = (IStaff) reg.lookup("StaffService");
        admin = (IAdmin) reg.lookup("AdminService");

        cmbBorder = cmbPosition.getBackground();
        txtBorder = txtEmail.getBorder();

        lblForgotPassword.setText("<html><u>Forgot Password?</u></html>");
        lblRegister.setText("<html><u>Register</u></html>");

        //cmbPosition Items
        cmbPosition.removeAllItems();
        cmbPosition.setModel(new DefaultComboBoxModel<>(arrPosition));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblForgotPassword = new javax.swing.JLabel();
        lblRegister = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbPosition = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setName("frmLogin"); // NOI18N
        setResizable(false);

        pnlLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Login Details :"));

        jLabel1.setText("Email : ");

        txtEmail.setToolTipText("Enter Email Address");
        txtEmail.setName("txtEmail"); // NOI18N
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        jLabel2.setText("Password : ");

        txtPassword.setToolTipText("Enter Password");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblForgotPassword.setForeground(new java.awt.Color(0, 0, 153));
        lblForgotPassword.setText("Forgot Password?");
        lblForgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgot_Password_Click(evt);
            }
        });

        lblRegister.setForeground(new java.awt.Color(0, 0, 153));
        lblRegister.setText("Register");
        lblRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegister_Click(evt);
            }
        });

        jLabel3.setText("Sign In As : ");

        cmbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPosition.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbPositionFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblRegister)
                        .addComponent(jLabel2)))
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblForgotPassword)
                            .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPassword)
                                .addComponent(cmbPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin)
                        .addContainerGap())))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblForgotPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(lblRegister))
                .addGap(153, 153, 153))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:   
        String userEmail = txtEmail.getText();
        char[] userPassword = txtPassword.getPassword();

        //Validation
        if (cmbPosition.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a valid option.", "Input Error", JOptionPane.ERROR_MESSAGE);
            cmbPosition.setFocusable(true);
            cmbPosition.requestFocus();
            return;
        }

        if (userEmail.trim().equals("") || !userEmail.contains("@")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Input Error", JOptionPane.ERROR_MESSAGE);
            txtEmail.setFocusable(true);
            txtEmail.requestFocus();
            return;
        }

        if (userPassword.length < 8) {
            JOptionPane.showMessageDialog(this, "Password should contain at least 8 characters.", "Input Error", JOptionPane.ERROR_MESSAGE);
            txtPassword.setFocusable(true);
            txtPassword.requestFocus();
            return;
        }

        //LOGIN
        switch (cmbPosition.getSelectedIndex()) {
            case 1:
                //LOGIN AS ADMINASTRATOR
                System.out.println("Login Form : " + userEmail);
                String[] resultAdmin = admin.signIn(userEmail, userPassword);

                if (resultAdmin[0].equals("Success")) {
                    new AdministrationForm().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, resultAdmin[1], resultAdmin[0], JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2:
                //LOGIN AS STAFF MEMBER
                String[] resultStaff = (String[]) staff.signIn(userEmail, userPassword);

                if (resultStaff[0].equals("Success")) {
                    try {
                        new StaffForm().setVisible(true);
                    } catch (RemoteException ex) {
                        Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NotBoundException ex) {
                        Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, resultStaff[1], resultStaff[0], JOptionPane.ERROR_MESSAGE);
                }
                break;
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblForgot_Password_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgot_Password_Click
        // TODO add your handling code here:

        JOptionPane.showMessageDialog(this, "You Clicked Me");


    }//GEN-LAST:event_lblForgot_Password_Click

    private void lblRegister_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegister_Click
        try {
            // TODO add your handling code here:
            new RegistrationForm().setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_lblRegister_Click

    private void cmbPositionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbPositionFocusLost
        // TODO add your handling code here:

        if (cmbPosition.getSelectedItem().equals(arrPosition[0])) {
            //cmbPosition.setBorder(BorderFactory.createLineBorder(Color.RED));
            cmbPosition.setBackground(Color.RED);
            cmbPosition.setToolTipText("Please select a valid position");
        } else {
            cmbPosition.setBackground(cmbBorder);
            cmbPosition.setToolTipText("Sign in as Staff or Admin");
        }

    }//GEN-LAST:event_cmbPositionFocusLost

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        if (txtEmail.getText().trim().equals("") || !txtEmail.getText().contains("@")) {
            txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtEmail.setToolTipText("Please enter a valid email.");
        } else {
            txtEmail.setBorder(txtBorder);
            txtEmail.setToolTipText("Your registered email.");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:        

    }//GEN-LAST:event_txtPasswordFocusLost

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new LoginForm().setVisible(true);
            } catch (RemoteException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cmbPosition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblForgotPassword;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
