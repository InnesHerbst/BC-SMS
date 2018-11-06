package UILayer;

import BusinessLayer.IStaff;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import BusinessLayer.IStaff;
import BusinessLayer.InputValidation;
import BusinessLayer.Staff;
import BusinessLayer.Stock;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Innes Herbst
 */
public class StaffForm extends javax.swing.JFrame {

    /**
     * Creates new form AdministrationForm
     */
    IStaff staff;

    private Staff currStaff;
    private final String[] campus = new String[]{"--Please Select--", "Pretoria", "Kempton", "Port Elizabeth"};
    private final String[] department = new String[]{"--Please Select--", "Programming", "Networking", "Information Systems"};

    public StaffForm() throws RemoteException, NotBoundException {
        try {
            initComponents();
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            staff = (IStaff) reg.lookup("StaffService");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Campus CMB
        cmbCampus.removeAllItems();
        cmbCampus.setModel(new DefaultComboBoxModel<>(campus));
        //Department CMB
        cmbDepartment.removeAllItems();
        cmbDepartment.setModel(new DefaultComboBoxModel<>(department));
    }

    private StaffForm(Staff currStaff) {
        this.currStaff = currStaff;
    }

    public void setFields(boolean enabled) {
        txtStaffID.setEnabled(enabled);
        txtFirstName.setEnabled(enabled);
        txtInitials.setEnabled(enabled);
        txtLastName.setEnabled(enabled);
        dtpDoB.setEnabled(enabled);
        rbnMale.setEnabled(enabled);
        rbnFemale.setEnabled(enabled);
        txtCellNum.setEnabled(enabled);
        txtEmail.setEnabled(enabled);
        txtAddress.setEnabled(enabled);
        cmbCampus.setEnabled(enabled);
        cmbDepartment.setEnabled(enabled);
        btnEdit.setEnabled(!enabled);
        btnSave.setEnabled(enabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rgpGender = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlStock = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSotck = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnQuant = new javax.swing.JButton();
        btnRequest = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        pnlSDet = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtStaffID = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtInitials = new javax.swing.JTextField();
        txtCellNum = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        cmbCampus = new javax.swing.JComboBox<>();
        cmbDepartment = new javax.swing.JComboBox<>();
        dtpDoB = new org.jdesktop.swingx.JXDatePicker();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        rbnMale = new javax.swing.JRadioButton();
        rbnFemale = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuLogout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administration");
        setName("frmStaff\n"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        pnlStock.setBackground(new java.awt.Color(102, 102, 102));
        pnlStock.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tblSotck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Catagory", "Description"
            }
        ));
        jScrollPane1.setViewportView(tblSotck);

        jLabel12.setText("Stock Available");

        btnQuant.setText("Update Quantity");

        btnRequest.setText("Request Stock");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        btnReport.setText("Generate Report");

        javax.swing.GroupLayout pnlStockLayout = new javax.swing.GroupLayout(pnlStock);
        pnlStock.setLayout(pnlStockLayout);
        pnlStockLayout.setHorizontalGroup(
            pnlStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addGroup(pnlStockLayout.createSequentialGroup()
                        .addGroup(pnlStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(pnlStockLayout.createSequentialGroup()
                                .addComponent(btnQuant)
                                .addGap(18, 18, 18)
                                .addComponent(btnRequest)
                                .addGap(18, 18, 18)
                                .addComponent(btnReport)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlStockLayout.setVerticalGroup(
            pnlStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuant)
                    .addComponent(btnRequest)
                    .addComponent(btnReport))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Stock", pnlStock);

        pnlSDet.setBackground(new java.awt.Color(102, 102, 102));
        pnlSDet.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnlSDetComponentShown(evt);
            }
        });

        jLabel1.setText("ID Number : ");

        jLabel2.setText("First Name : ");

        jLabel3.setText("Initials : ");

        jLabel4.setText("Date of Birth : ");

        jLabel5.setText("Gender : ");

        jLabel6.setText("Email : ");

        jLabel7.setText("Phone Number : ");

        jLabel8.setText("Address : ");

        jLabel9.setText("Campus : ");

        jLabel10.setText("Department : ");

        txtStaffID.setName("txtStaffID"); // NOI18N
        txtStaffID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStaffIDActionPerformed(evt);
            }
        });

        txtFirstName.setName("txtFirstName"); // NOI18N

        txtInitials.setName("txtInitials"); // NOI18N

        txtCellNum.setName("txtCellNum"); // NOI18N

        txtEmail.setName("txtEmail"); // NOI18N

        txtAddress.setName("txtAddress"); // NOI18N

        cmbCampus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCampus.setName("cmbCampus"); // NOI18N

        cmbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDepartment.setName("cmbDept"); // NOI18N

        dtpDoB.setName("dpkDoB"); // NOI18N

        btnEdit.setText("Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        rbnMale.setBackground(new java.awt.Color(102, 102, 102));
        rgpGender.add(rbnMale);
        rbnMale.setText("Male");

        rbnFemale.setBackground(new java.awt.Color(102, 102, 102));
        rgpGender.add(rbnFemale);
        rbnFemale.setText("Female");

        jLabel11.setText("Last Name : ");

        txtLastName.setName("txtLastName"); // NOI18N

        javax.swing.GroupLayout pnlSDetLayout = new javax.swing.GroupLayout(pnlSDet);
        pnlSDet.setLayout(pnlSDetLayout);
        pnlSDetLayout.setHorizontalGroup(
            pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSDetLayout.createSequentialGroup()
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSDetLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStaffID, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(txtFirstName)
                            .addComponent(txtInitials)
                            .addComponent(txtLastName))
                        .addGap(0, 234, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSDetLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)))
                .addContainerGap())
            .addGroup(pnlSDetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCellNum)
                    .addComponent(txtEmail)
                    .addComponent(txtAddress)
                    .addComponent(cmbCampus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtpDoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlSDetLayout.createSequentialGroup()
                        .addComponent(rbnMale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(rbnFemale)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSDetLayout.setVerticalGroup(
            pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSDetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtInitials, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dtpDoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rbnMale)
                    .addComponent(rbnFemale))
                .addGap(18, 18, 18)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCellNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlSDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        jTabbedPane1.addTab("My Details", pnlSDet);

        mnuLogout.setText("Log Out");
        mnuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuLogoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuLogout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlSDetComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlSDetComponentShown
        txtStaffID.setText(currStaff.getP_ID());
        txtFirstName.setText(currStaff.getP_firstname());
        txtLastName.setText(currStaff.getP_lastname());
        txtInitials.setText(currStaff.getP_initials());
        //DOB
        switch (currStaff.getP_gender()) {
            case "Male":
                rbnMale.setSelected(true);
                break;
            case "Female":
                rbnFemale.setSelected(true);
                break;
        }
        txtCellNum.setText(currStaff.getP_phone());
        txtEmail.setText(currStaff.getP_email());
        txtAddress.setText(currStaff.getP_email());
        cmbCampus.setSelectedIndex(currStaff.getCampus_id());
        cmbDepartment.setSelectedIndex(currStaff.getDepartment_id());
        setFields(false);
    }//GEN-LAST:event_pnlSDetComponentShown

    private void mnuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuLogoutMouseClicked
        try {
            new LoginForm().setVisible(true);
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuLogoutMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        setFields(true);
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        try {
            //Gather information
            String sID = txtStaffID.getText();
            String sFName = txtFirstName.getText();
            String sIni = txtInitials.getText();
            String sLName = txtLastName.getText();
            Date sDoB = dtpDoB.getDate();
            String sGender = "";
            String sCell = txtCellNum.getText();
            String sEmail = txtEmail.getText();
            String sAddress = txtAddress.getText();
            char[] sPassword = currStaff.getP_password();

            //RADIOBUTTON VALIDATION
            if (!rbnFemale.isSelected() && !rbnMale.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please select a gender", "Input Error", JOptionPane.ERROR_MESSAGE);
                rbnFemale.setFocusable(true);
                rbnFemale.requestFocus();
                return;
            } else if (rbnFemale.isSelected()) {
                sGender = "Female";
            } else {
                sGender = "Male";
            }

            //CMB Validation
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

            //STRING VALIDATION
            if (sID.trim().equals("") || sID.length() != 13 || !InputValidation.isNumeric(sID)) {
                JOptionPane.showMessageDialog(this, "Please input a valid ID.\nID should be 13 numerical characters.", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtStaffID.setFocusable(true);
                txtStaffID.requestFocus();
                return;
            }
            if (sFName.trim().equals("") || !InputValidation.isString(sFName)) {
                JOptionPane.showMessageDialog(this, "Please input a valid first name. Alphabet letters only.", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtFirstName.setFocusable(true);
                txtFirstName.requestFocus();
                return;
            }
            if (sIni.trim().equals("") || !InputValidation.isString(sIni)) {
                JOptionPane.showMessageDialog(this, "Please input a valid initial. Alphabet letters only.", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtInitials.setFocusable(true);
                txtInitials.requestFocus();
                return;
            }
            if (sLName.trim().equals("") || !InputValidation.isString(sLName)) {
                JOptionPane.showMessageDialog(this, "Please input a valid last name. Alphabet letters only.", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtLastName.setFocusable(true);
                txtLastName.requestFocus();
                return;
            }
            if (sCell.trim().equals("") || sCell.length() < 10 || !InputValidation.isNumeric(sCell)) {
                JOptionPane.showMessageDialog(this, "Please input a valid cell number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtCellNum.setFocusable(true);
                txtCellNum.requestFocus();
                return;
            }
            if (sEmail.trim().equals("") || !sEmail.contains("@")) {
                JOptionPane.showMessageDialog(this, "Please input a valid email address.", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtEmail.setFocusable(true);
                txtEmail.requestFocus();
                return;
            }

            if (sAddress.trim().equals("") || !InputValidation.isAlphaNum(sAddress)) {
                JOptionPane.showMessageDialog(this, "Please input a valid address.", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtAddress.setFocusable(true);
                txtAddress.requestFocus();
                return;
            }
            //Update Database
            Staff nStaff = new Staff(cmbCampus.getSelectedIndex(), cmbDepartment.getSelectedIndex(), sID, sIni, sFName, sLName, sDoB, sGender, sCell, sEmail, sPassword, sAddress, "null");
            String[] resultStaff = staff.UpdateStaff(sID, nStaff);

            if (resultStaff[0].equals("Success")) {
                JOptionPane.showMessageDialog(this, "Save Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                new LoginForm().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, resultStaff[1], resultStaff[0], JOptionPane.ERROR_MESSAGE);
            }
            //Refresh values
            //Set Fields False
            setFields(false);
        } catch (RemoteException ex) {
            Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void txtStaffIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStaffIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStaffIDActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        try {
            // TODO add your handling code here:
            Staff_AddStockForm saf = new Staff_AddStockForm();
            saf.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex) {
            Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRequestActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        List<Stock> ls = Stock.DisplayStock();

        DefaultTableModel model = (DefaultTableModel) tblSotck.getModel();

        model.setRowCount(0);

        for (Stock l : ls) {
            model.addRow(new Object[]{l.getId(), l.getName(), l.getPrice(), l.getQuantity(), l.getCategory(), l.getDescription()});
        }
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(StaffForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StaffForm().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnQuant;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbCampus;
    private javax.swing.JComboBox<String> cmbDepartment;
    private org.jdesktop.swingx.JXDatePicker dtpDoB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenu mnuLogout;
    private javax.swing.JPanel pnlSDet;
    private javax.swing.JPanel pnlStock;
    private javax.swing.JRadioButton rbnFemale;
    private javax.swing.JRadioButton rbnMale;
    private javax.swing.ButtonGroup rgpGender;
    private javax.swing.JTable tblSotck;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCellNum;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtInitials;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtStaffID;
    // End of variables declaration//GEN-END:variables
}
