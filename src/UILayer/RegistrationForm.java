/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UILayer;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Innes Herbst
 */
public class RegistrationForm extends javax.swing.JFrame {

    /**
     * Creates new form RegistrationForm
     */
    private final Border tFieldBorder;
    private final Color cmbBorder;
    private final String[] campus = new String[]{"--Please Select--", "Pretoria", "Kempton", "Port Elizabeth"};
    private final String[] department = new String[]{"--Please Select--", "Programming", "Networking", "Information Systems"};
    private final String[] position = new String[]{"--Please Select--", "Staff Member", "Administrator"};

    public RegistrationForm() {
        initComponents();

        tFieldBorder = txtFirstName.getBorder();
        cmbBorder = cmbPosition.getBackground();

        //Set the date for DoB Picker
        SimpleDateFormat sdf = new SimpleDateFormat("dd, MMMM yyyy");
        Calendar calender = Calendar.getInstance();
        calender.add(Calendar.YEAR, -18);
        dpkDoB.setDate(calender.getTime());
        dpkDoB.getMonthView().setUpperBound(calender.getTime());
        calender.add(Calendar.YEAR, -82);
        dpkDoB.getMonthView().setLowerBound(calender.getTime());
        dpkDoB.setFormats(sdf);

        //Campus CMB
        cmbCampus.removeAllItems();
        cmbCampus.setModel(new DefaultComboBoxModel<>(campus));
        //Department CMB
        cmbDepartment.removeAllItems();
        cmbDepartment.setModel(new DefaultComboBoxModel<>(department));
        //Position CMB
        cmbPosition.removeAllItems();
        cmbPosition.setModel(new DefaultComboBoxModel<>(position));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgpGender = new javax.swing.ButtonGroup();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        pnlRegister = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtInitial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStaffID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        rbnMale = new javax.swing.JRadioButton();
        rbnFemale = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtCellNum = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSAddrress = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbCampus = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbDepartment = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        cmbPosition = new javax.swing.JComboBox<>();
        dpkDoB = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setName("frmRegistration"); // NOI18N
        setResizable(false);

        pnlRegister.setBorder(javax.swing.BorderFactory.createTitledBorder("Register"));

        jLabel1.setText("First Name : ");

        txtFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFirstNameFocusLost(evt);
            }
        });

        jLabel2.setText("Initials : ");

        txtInitial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtInitialFocusLost(evt);
            }
        });

        jLabel3.setText("ID : ");

        txtStaffID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStaffIDFocusLost(evt);
            }
        });

        jLabel4.setText("Last Name : ");

        txtLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLastNameFocusLost(evt);
            }
        });

        jLabel5.setText("Date Of Birth : ");

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        jLabel6.setText("Gender : ");

        bgpGender.add(rbnMale);
        rbnMale.setText("Male");

        bgpGender.add(rbnFemale);
        rbnFemale.setText("Female");

        jLabel7.setText("Cell : ");

        txtCellNum.setToolTipText("Cell Number");
        txtCellNum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCellNumFocusLost(evt);
            }
        });

        jLabel8.setText("Email : ");

        txtEmail.setToolTipText("Email Address");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        jLabel9.setText("Address : ");

        txtSAddrress.setToolTipText("Street Address");
        txtSAddrress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSAddrressFocusLost(evt);
            }
        });

        jLabel10.setText("Campus : ");

        cmbCampus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCampus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbCampusFocusLost(evt);
            }
        });

        jLabel11.setText("Department : ");

        cmbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDepartment.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbDepartmentFocusLost(evt);
            }
        });

        jLabel12.setText("Password : ");

        txtPassword.setToolTipText("Enter preffered password");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });

        jLabel13.setText("Position : ");

        cmbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPosition.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbPositionFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlRegisterLayout = new javax.swing.GroupLayout(pnlRegister);
        pnlRegister.setLayout(pnlRegisterLayout);
        pnlRegisterLayout.setHorizontalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLayout.createSequentialGroup()
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegisterLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCampus, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDepartment, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlRegisterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegisterLayout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegister))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegisterLayout.createSequentialGroup()
                                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlRegisterLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCellNum))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegisterLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlRegisterLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtInitial, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtStaffID, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pnlRegisterLayout.createSequentialGroup()
                                                .addComponent(rbnFemale)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbnMale))
                                            .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(dpkDoB, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegisterLayout.createSequentialGroup()
                                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addComponent(txtSAddrress))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRegisterLayout.setVerticalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtInitial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dpkDoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbnMale)
                    .addComponent(rbnFemale))
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCellNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSAddrress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void txtFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstNameFocusLost
        // TODO add your handling code here:        
        String fName = txtFirstName.getText();

        if (fName.trim().equals("")) {
            txtFirstName.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtFirstName.setToolTipText("Plese enter your first name.");
        } else {
            //txtFirstName.setBorder();
            txtFirstName.setBorder(tFieldBorder);
            txtFirstName.setToolTipText("Your First Name.");
        }
    }//GEN-LAST:event_txtFirstNameFocusLost

    private void txtInitialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInitialFocusLost
        // TODO add your handling code here:
        String uIni = txtInitial.getText();

        if (uIni.trim().equals("")) {
            txtInitial.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtInitial.setToolTipText("Please enter your initials.");
        } else {
            //txtFirstName.setBorder();
            txtInitial.setBorder(tFieldBorder);
            txtInitial.setToolTipText("Your initials.");
        }
    }//GEN-LAST:event_txtInitialFocusLost

    private void txtStaffIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStaffIDFocusLost
        // TODO add your handling code here:
        String uID = txtStaffID.getText();

        if (uID.trim().equals("") || (uID.trim().length() != 13)) {
            txtStaffID.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtStaffID.setToolTipText("Please enter your national ID.(13 Characters)");
        } else {
            //txtFirstName.setBorder();
            txtStaffID.setBorder(tFieldBorder);
            txtStaffID.setToolTipText("Your national ID.");
        }
    }//GEN-LAST:event_txtStaffIDFocusLost

    private void txtLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastNameFocusLost
        // TODO add your handling code here:
        String iLName = txtLastName.getText();

        if (iLName.trim().equals("")) {
            txtLastName.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtLastName.setToolTipText("Please enter your last name.");
        } else {
            //txtFirstName.setBorder();
            txtLastName.setBorder(tFieldBorder);
            txtLastName.setToolTipText("Your last name.");
        }
    }//GEN-LAST:event_txtLastNameFocusLost

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        // TODO add your handling code here:
        new LoginForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    private void txtCellNumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCellNumFocusLost
        // TODO add your handling code here:
        String uCNum = txtCellNum.getText();

        if (uCNum.trim().equals("") || (uCNum.trim().length() != 10)) {
            txtCellNum.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtCellNum.setToolTipText("Please enter your cell number.(10 Characters)");
        } else {
            //txtFirstName.setBorder();
            txtCellNum.setBorder(tFieldBorder);
            txtCellNum.setToolTipText("Your cell number.");
        }
    }//GEN-LAST:event_txtCellNumFocusLost

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        String uEmail = txtEmail.getText();

        if (uEmail.trim().equals("") || !uEmail.contains("@")) {
            txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtEmail.setToolTipText("Please enter your email address. eg. john.doe@gmail.co.za");
        } else {
            //txtFirstName.setBorder();
            txtEmail.setBorder(tFieldBorder);
            txtEmail.setToolTipText("Your email address.");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        char[] uPword = txtPassword.getPassword();

        if (uPword.length < 8) {
            txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtPassword.setToolTipText("Password should be at least 8 characters.");
        } else {
            //txtFirstName.setBorder();
            txtPassword.setBorder(tFieldBorder);
            txtPassword.setToolTipText("Your password.");
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtSAddrressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSAddrressFocusLost
        String uAddress = txtSAddrress.getText();

        if (uAddress.trim().equals("")) {
            txtSAddrress.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtSAddrress.setToolTipText("Please enter your street address. eg. 123 Somewhere Rd.");
        } else {
            //txtFirstName.setBorder();
            txtSAddrress.setBorder(tFieldBorder);
            txtSAddrress.setToolTipText("Your street address");
        }
    }//GEN-LAST:event_txtSAddrressFocusLost

    private void cmbPositionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbPositionFocusLost

        if (cmbPosition.getSelectedIndex() == 0) {
            cmbPosition.setBackground(Color.red);
            //cmbPosition.setBorder(BorderFactory.createLineBorder(Color.RED));
            cmbPosition.setToolTipText("Please choose a valid position.");
        } else {
            //txtFirstName.setBorder();
            //cmbPosition.setBorder(cmbBorder);
            cmbPosition.setBackground(cmbBorder);
            cmbPosition.setToolTipText("Your position.");
        }

        if (cmbPosition.getSelectedItem().equals(position[2])) {
            if (cmbDepartment.isEnabled()) {
                cmbDepartment.setEnabled(false);
            }
        } else {
            if (!cmbDepartment.isEnabled()) {
                cmbDepartment.setEnabled(true);
            }
        }
    }//GEN-LAST:event_cmbPositionFocusLost

    private void cmbCampusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbCampusFocusLost
        if (cmbCampus.getSelectedIndex() == 0) {
            //cmbCampus.setBorder(BorderFactory.createLineBorder(Color.RED));
            cmbCampus.setBackground(Color.RED);
            cmbCampus.setToolTipText("Please choose a valid campus.");
        } else {
            //txtFirstName.setBorder();
            //cmbCampus.setBorder(cmbBorder);
            cmbCampus.setBackground(cmbBorder);
            cmbCampus.setToolTipText("Your campus.");
        }
    }//GEN-LAST:event_cmbCampusFocusLost

    private void cmbDepartmentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbDepartmentFocusLost
        if (cmbDepartment.getSelectedIndex() == 0) {
            //cmbDepartment.setBorder(BorderFactory.createLineBorder(Color.RED));
            cmbDepartment.setBackground(Color.RED);
            cmbDepartment.setToolTipText("Please choose a valid department.");
        } else {
            //txtFirstName.setBorder();
            //cmbDepartment.setBorder(cmbBorder);
            cmbDepartment.setBackground(cmbBorder);
            cmbDepartment.setToolTipText("Your department.");
        }
    }//GEN-LAST:event_cmbDepartmentFocusLost

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        //Validation

        String uID = txtStaffID.getText();
        String uFName = txtFirstName.getText();
        String uIni = txtInitial.getText();
        String uLName = txtLastName.getText();
        Date uDoB = dpkDoB.getDate();
        String uGender = "";
        String uCell = txtCellNum.getText();
        String uEmail = txtEmail.getText();
        char[] uPassword = txtPassword.getPassword();
        String uAddress = txtSAddrress.getText();

        if (!rbnFemale.isSelected() && !rbnMale.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a gender", "Input Error", JOptionPane.ERROR_MESSAGE);
            rbnFemale.setFocusable(true);
            rbnFemale.requestFocus();
            return;
        } else if (rbnFemale.isSelected()) {
            uGender = "Female";
        } else {
            uGender = "Male";
        }

        if (cmbPosition.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a position", "Input Error", JOptionPane.ERROR_MESSAGE);
            cmbPosition.setFocusable(true);
            cmbPosition.requestFocus();
            return;
        }
        if (cmbCampus.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a campus", "Input Error", JOptionPane.ERROR_MESSAGE);
            cmbCampus.setFocusable(true);
            cmbCampus.requestFocus();
            return;
        }
        if (cmbDepartment.isEnabled() && cmbDepartment.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a department", "Input Error", JOptionPane.ERROR_MESSAGE);
            cmbDepartment.setFocusable(true);
            cmbDepartment.requestFocus();
            return;
        }
        
        //STILL VALIDATING -- NEXT IS STRINGS
    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgpGender;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cmbCampus;
    private javax.swing.JComboBox<String> cmbDepartment;
    private javax.swing.JComboBox<String> cmbPosition;
    private org.jdesktop.swingx.JXDatePicker dpkDoB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JPanel pnlRegister;
    private javax.swing.JRadioButton rbnFemale;
    private javax.swing.JRadioButton rbnMale;
    private javax.swing.JTextField txtCellNum;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtInitial;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSAddrress;
    private javax.swing.JTextField txtStaffID;
    // End of variables declaration//GEN-END:variables
}
