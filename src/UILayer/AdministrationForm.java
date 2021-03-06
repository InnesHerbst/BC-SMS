/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UILayer;

import BusinessLayer.Staff;
import BusinessLayer.Stock;
import BusinessLayer.StockQuantComparator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Innes Herbst
 */
public class AdministrationForm extends javax.swing.JFrame {

    enum SortMethod {
        NoSort,
        NameSort,
        QuantSort;
    }

    enum EmployeeSort {
        NoSort,
        Pretoria,
        Kempton,
        PortEliz;
    }

    private final String[] sort = new String[]{"No Sorting", "By Name", "By Quantity"};
    private final String[] empSort = new String[]{"No Sorting", "Pretoria Campus", "Kempton Campus", "Port Elizabeth Campus"};
    private int cmbPrevIndex = 0;
    private int cmbEPrevIndex = 0;

    /**
     * Creates new form AdministrationForm
     */
    public AdministrationForm() {
        initComponents();

        cmbSort.removeAllItems();
        cmbSort.setModel(new DefaultComboBoxModel<>(sort));
        cmbSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbSort.getSelectedIndex() != cmbPrevIndex) {
                    displayStockTableData(SortMethod.values()[cmbSort.getSelectedIndex()], "null");
                    cmbPrevIndex = cmbSort.getSelectedIndex();
                }
            }
        });

        cmbSortEmploy.removeAllItems();
        cmbSortEmploy.setModel(new DefaultComboBoxModel<>(empSort));
        cmbSortEmploy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbSortEmploy.getSelectedIndex() != cmbEPrevIndex) {
                    displayEmployeeData(EmployeeSort.values()[cmbSortEmploy.getSelectedIndex()], "null");
                    cmbEPrevIndex = cmbSortEmploy.getSelectedIndex();
                }
            }
        });
    }

    private void displayStockTableData(SortMethod sort, String searchStatement) {
        List<Stock> stock = Stock.DisplayStock();
        List<Stock> definedStock = null;
        if (!searchStatement.equals("null")) {
            definedStock = stock;
            stock = definedStock.stream()
                    .filter(item -> item.getName().contains(searchStatement))
                    .collect(Collectors.toList());
        }

        switch (sort) {
            case NoSort:
                DefaultTableModel noSortModel = (DefaultTableModel) jtblStock.getModel();

                noSortModel.setRowCount(0);

                for (Stock l : stock) {
                    noSortModel.addRow(new Object[]{l.getId(), l.getName(), l.getPrice(), l.getQuantity(), l.getCategory(), l.getDescription()});
                }
                break;
            case NameSort:
                Collections.sort(stock);
                DefaultTableModel nameSortModel = (DefaultTableModel) jtblStock.getModel();

                nameSortModel.setRowCount(0);

                for (Stock l : stock) {
                    nameSortModel.addRow(new Object[]{l.getId(), l.getName(), l.getPrice(), l.getQuantity(), l.getCategory(), l.getDescription()});
                }
                break;
            case QuantSort:
                StockQuantComparator sqc = new StockQuantComparator();
                Collections.sort(stock, sqc);
                DefaultTableModel quantSortModel = (DefaultTableModel) jtblStock.getModel();

                quantSortModel.setRowCount(0);

                for (Stock l : stock) {
                    quantSortModel.addRow(new Object[]{l.getId(), l.getName(), l.getPrice(), l.getQuantity(), l.getCategory(), l.getDescription()});
                }
                break;
        }
    }

    private void displayEmployeeData(EmployeeSort sortMethod, String searchString) {
        List<Staff> staff = Staff.fetchStaffData();
        List<Staff> definedStaff = null;
        if (!searchString.equals("null")) {
            definedStaff = staff;
            staff = definedStaff.stream()
                    .filter(item -> item.getP_lastname().contains(searchString))
                    .collect(Collectors.toList());
        }

        switch (sortMethod) {
            case NoSort:

                break;
            case Kempton:
                //2
                definedStaff = staff;
                staff = definedStaff.stream()
                        .filter(item -> item.getCampus_id() == 2).collect(Collectors.toList());
                break;
            case PortEliz:
                //3
                definedStaff = staff;
                staff = definedStaff.stream()
                        .filter(item -> item.getCampus_id() == 3).collect(Collectors.toList());
                break;
            case Pretoria:
                //1
                definedStaff = staff;
                staff = definedStaff.stream()
                        .filter(item -> item.getCampus_id() == 1).collect(Collectors.toList());
                break;
        }

        DefaultTableModel staffModel = (DefaultTableModel) jtblStaff.getModel();
        staffModel.setRowCount(0);

        for (Staff staff1 : staff) {
            staffModel.addRow(new Object[]{staff1.getP_ID(), staff1.getP_initials(), staff1.getP_firstname(), staff1.getP_lastname(),
                staff1.getP_dob(), staff1.getP_gender(), staff1.getP_phone(), staff1.getP_email(),
                staff1.getP_address1(), staff1.getP_address2()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpAdmin = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblStock = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbSort = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JToggleButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUnAuthStock = new javax.swing.JTable();
        btnAuthOrder = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblStaff = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblStaffUn = new javax.swing.JTable();
        cmbSortEmploy = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSEmploy = new javax.swing.JTextField();
        btnSEmploy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administration");
        setName("frmAdmin"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tbpAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        tbpAdmin.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(1));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        jtblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Category", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtblStock);
        if (jtblStock.getColumnModel().getColumnCount() > 0) {
            jtblStock.getColumnModel().getColumn(0).setResizable(false);
            jtblStock.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtblStock.getColumnModel().getColumn(1).setResizable(false);
            jtblStock.getColumnModel().getColumn(2).setResizable(false);
            jtblStock.getColumnModel().getColumn(3).setResizable(false);
            jtblStock.getColumnModel().getColumn(4).setResizable(false);
            jtblStock.getColumnModel().getColumn(5).setResizable(false);
        }
        jtblStock.getAccessibleContext().setAccessibleName("tblStock");

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Sort By : ");

        cmbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Search : ");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setText("GO!");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jButton6.setText("Log out");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Regester new Product");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        tblUnAuthStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Category", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblUnAuthStock);
        if (tblUnAuthStock.getColumnModel().getColumnCount() > 0) {
            tblUnAuthStock.getColumnModel().getColumn(0).setResizable(false);
            tblUnAuthStock.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblUnAuthStock.getColumnModel().getColumn(1).setResizable(false);
            tblUnAuthStock.getColumnModel().getColumn(2).setResizable(false);
            tblUnAuthStock.getColumnModel().getColumn(3).setResizable(false);
            tblUnAuthStock.getColumnModel().getColumn(4).setResizable(false);
            tblUnAuthStock.getColumnModel().getColumn(5).setResizable(false);
        }

        btnAuthOrder.setText("Authorize Stock");
        btnAuthOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuthOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jButton7))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAuthOrder))
                        .addGap(0, 114, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAuthOrder)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbpAdmin.addTab("Stock", jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(1));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jtblStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Initials", "Name", "Surname", "Dob", "Gender", "Phone", "Email", "Address1", "Address2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtblStaff);
        if (jtblStaff.getColumnModel().getColumnCount() > 0) {
            jtblStaff.getColumnModel().getColumn(0).setResizable(false);
            jtblStaff.getColumnModel().getColumn(1).setResizable(false);
            jtblStaff.getColumnModel().getColumn(2).setResizable(false);
            jtblStaff.getColumnModel().getColumn(3).setResizable(false);
            jtblStaff.getColumnModel().getColumn(4).setResizable(false);
            jtblStaff.getColumnModel().getColumn(5).setResizable(false);
            jtblStaff.getColumnModel().getColumn(6).setResizable(false);
            jtblStaff.getColumnModel().getColumn(7).setResizable(false);
            jtblStaff.getColumnModel().getColumn(8).setResizable(false);
            jtblStaff.getColumnModel().getColumn(9).setResizable(false);
        }

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jtblStaffUn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Initials", "Name", "Surname", "Dob", "Gender", "Phone", "Email", "Address1", "Address2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtblStaffUn);
        if (jtblStaffUn.getColumnModel().getColumnCount() > 0) {
            jtblStaffUn.getColumnModel().getColumn(0).setResizable(false);
            jtblStaffUn.getColumnModel().getColumn(1).setResizable(false);
            jtblStaffUn.getColumnModel().getColumn(2).setResizable(false);
            jtblStaffUn.getColumnModel().getColumn(3).setResizable(false);
            jtblStaffUn.getColumnModel().getColumn(4).setResizable(false);
            jtblStaffUn.getColumnModel().getColumn(5).setResizable(false);
            jtblStaffUn.getColumnModel().getColumn(6).setResizable(false);
            jtblStaffUn.getColumnModel().getColumn(7).setResizable(false);
            jtblStaffUn.getColumnModel().getColumn(8).setResizable(false);
            jtblStaffUn.getColumnModel().getColumn(9).setResizable(false);
        }

        cmbSortEmploy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Sort By :");

        jLabel4.setText("Search : ");

        btnSEmploy.setText("GO!");
        btnSEmploy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSEmployActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtSEmploy, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSEmploy))
                            .addComponent(cmbSortEmploy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbSortEmploy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSEmploy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSEmploy)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );

        tbpAdmin.addTab("Employees", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpAdmin)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

        // TODO add your handling code here:
        //Stock st = new Stock(1, "Dimond", 20.52, 7, "Jewl", "Shiny");
        List<Stock> ls = Stock.DisplayStock();

        DefaultTableModel model = (DefaultTableModel) jtblStock.getModel();

        model.setRowCount(0);

        for (Stock l : ls) {
            model.addRow(new Object[]{l.getId(), l.getName(), l.getPrice(), l.getQuantity(), l.getCategory(), l.getDescription()});
        }

        List<Stock> unAuthStock = Stock.GetUnAuthStock();

        DefaultTableModel unAuthModel = (DefaultTableModel) tblUnAuthStock.getModel();

        unAuthModel.setRowCount(0);

        for (Stock l : unAuthStock) {
            unAuthModel.addRow(new Object[]{l.getId(), l.getName(), l.getPrice(), l.getQuantity(), l.getCategory(), l.getDescription()});
        }

        List<Staff> staff = Staff.fetchStaffData();

        DefaultTableModel staffModel = (DefaultTableModel) jtblStaff.getModel();

        for (Staff staff1 : staff) {
            staffModel.addRow(new Object[]{staff1.getP_ID(), staff1.getP_initials(), staff1.getP_firstname(), staff1.getP_lastname(),
                staff1.getP_dob(), staff1.getP_gender(), staff1.getP_phone(), staff1.getP_email(),
                staff1.getP_address1(), staff1.getP_address2()});
        }

        List<Staff> unStaff = Staff.fetchUnAuthStaffData();

        DefaultTableModel staffUn = (DefaultTableModel) jtblStaffUn.getModel();

        for (Staff staff1 : unStaff) {
            staffUn.addRow(new Object[]{staff1.getP_ID(), staff1.getP_initials(), staff1.getP_firstname(), staff1.getP_lastname(),
                staff1.getP_dob(), staff1.getP_gender(), staff1.getP_phone(), staff1.getP_email(),
                staff1.getP_address1(), staff1.getP_address2()});
        }
    }//GEN-LAST:event_formComponentShown

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2ComponentShown

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            int selectedRowIndex = jtblStaff.getSelectedRow();
            String sID = (String) jtblStaff.getModel().getValueAt(selectedRowIndex, 0);

            Staff.DeleteStaff(sID);

            String[] result = Staff.authStaff(sID);

            List<Staff> staff = Staff.fetchStaffData();

            DefaultTableModel staffModel = (DefaultTableModel) jtblStaff.getModel();
            staffModel.setRowCount(0);

            for (Staff staff1 : staff) {
                staffModel.addRow(new Object[]{staff1.getP_ID(), staff1.getP_initials(), staff1.getP_firstname(), staff1.getP_lastname(),
                    staff1.getP_dob(), staff1.getP_gender(), staff1.getP_phone(), staff1.getP_email(),
                    staff1.getP_address1(), staff1.getP_address2()});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pleas Select a item", "Error", JOptionPane.WARNING_MESSAGE);
            System.out.println(e.getMessage());
        }

        RefreshStaff();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //AUTH Staff
        try {
            int selectedRowIndex = jtblStaffUn.getSelectedRow();
            String sID = (String) jtblStaffUn.getModel().getValueAt(selectedRowIndex, 0);

            String[] result = Staff.authStaff(sID);

            if (result[0].equals("Success")) {
                jtblStaffUn.remove(selectedRowIndex);

                List<Staff> staff = Staff.fetchStaffData();

                DefaultTableModel staffModel = (DefaultTableModel) jtblStaff.getModel();
                staffModel.setRowCount(0);

                for (Staff staff1 : staff) {
                    staffModel.addRow(new Object[]{staff1.getP_ID(), staff1.getP_initials(), staff1.getP_firstname(), staff1.getP_lastname(),
                        staff1.getP_dob(), staff1.getP_gender(), staff1.getP_phone(), staff1.getP_email(),
                        staff1.getP_address1(), staff1.getP_address2()});
                }

            } else {
                JOptionPane.showMessageDialog(null, result[1], result[0], JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pleas Select a item", "Error", JOptionPane.WARNING_MESSAGE);
        }

        RefreshStaff();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentShown

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        String searchStatement = txtSearch.getText().toUpperCase();

        if (!searchStatement.trim().equals("")) {
            displayStockTableData(SortMethod.values()[cmbSort.getSelectedIndex()], searchStatement);
        } else {
            displayStockTableData(SortMethod.values()[cmbSort.getSelectedIndex()], "null");
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //When Delte is pressd
        Stock st = new Stock(1, "Dimond", 20.52, 7, "Jewl", "Shiny");
        try {
            int selectedRowIndex = jtblStock.getSelectedRow();
            int id = (int) jtblStock.getModel().getValueAt(selectedRowIndex, 0);
            String name = (String) jtblStock.getModel().getValueAt(selectedRowIndex, 1);
            st.DeleteStock(id, name);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pleas Select a item", "Error", JOptionPane.WARNING_MESSAGE);
        }

        //Refresh the form
        List<Stock> ls = st.DisplayStock();

        DefaultTableModel model = (DefaultTableModel) jtblStock.getModel();
        model.setRowCount(0);

        for (Stock l : ls) {
            model.addRow(new Object[]{l.getId(), l.getName(), l.getPrice(), l.getQuantity(), l.getCategory(), l.getDescription()});
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            Stock_AddForm sa = new Stock_AddForm();
            sa.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex) {
            Logger.getLogger(AdministrationForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(AdministrationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        try {
            int selectedRowIndex = jtblStock.getSelectedRow();
            int id = (int) jtblStock.getModel().getValueAt(selectedRowIndex, 0);
            String name = (String) jtblStock.getModel().getValueAt(selectedRowIndex, 1);
            Stock_UpdateForm su = new Stock_UpdateForm();
            su.getID(id);
            su.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pleas Select a item", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            LoginForm lf = new LoginForm();
            lf.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex) {
            Logger.getLogger(AdministrationForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(AdministrationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            // TODO add your handling code here:
            Product_AddForm pa = new Product_AddForm();
            pa.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex) {
            Logger.getLogger(AdministrationForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(AdministrationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnSEmployActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSEmployActionPerformed
        if (txtSEmploy.getText().trim().equals("")) {
            displayEmployeeData(EmployeeSort.values()[cmbEPrevIndex], "null");
        } else {
            String sStatement = txtSEmploy.getText().trim();

            displayEmployeeData(EmployeeSort.values()[cmbEPrevIndex], sStatement);
        }
    }//GEN-LAST:event_btnSEmployActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnAuthOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuthOrderActionPerformed
        int selectedRowIndex = tblUnAuthStock.getSelectedRow();
        int id = (int) tblUnAuthStock.getModel().getValueAt(selectedRowIndex, 0);
        System.out.println(id);

        if (Stock.UpdateStock(id)) {
            System.out.println("Im here");
            List<Stock> unAuthStock = Stock.GetUnAuthStock();

            DefaultTableModel unAuthModel = (DefaultTableModel) tblUnAuthStock.getModel();

            unAuthModel.setRowCount(0);

            for (Stock l : unAuthStock) {
                unAuthModel.addRow(new Object[]{l.getId(), l.getName(), l.getPrice(), l.getQuantity(), l.getCategory(), l.getDescription()});
            }
            
            displayStockTableData(SortMethod.NoSort, "null");
        }else{
            JOptionPane.showMessageDialog(null, "An error occurred, Please try again", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAuthOrderActionPerformed

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
            java.util.logging.Logger.getLogger(AdministrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrationForm().setVisible(true);

            }

        });
    }

    public void RefreshStaff() {

        //Autherised staff
        List<Staff> staff = Staff.fetchStaffData();

        DefaultTableModel staffModel = (DefaultTableModel) jtblStaff.getModel();
        staffModel.setRowCount(0);

        for (Staff staff1 : staff) {
            staffModel.addRow(new Object[]{staff1.getP_ID(), staff1.getP_initials(), staff1.getP_firstname(), staff1.getP_lastname(),
                staff1.getP_dob(), staff1.getP_gender(), staff1.getP_phone(), staff1.getP_email(),
                staff1.getP_address1(), staff1.getP_address2()});
        }

        //un Autherised staff
        List<Staff> unStaff = Staff.fetchUnAuthStaffData();

        DefaultTableModel staffUn = (DefaultTableModel) jtblStaffUn.getModel();
        staffUn.setRowCount(0);

        for (Staff staff1 : unStaff) {
            staffUn.addRow(new Object[]{staff1.getP_ID(), staff1.getP_initials(), staff1.getP_firstname(), staff1.getP_lastname(),
                staff1.getP_dob(), staff1.getP_gender(), staff1.getP_phone(), staff1.getP_email(),
                staff1.getP_address1(), staff1.getP_address2()});
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuthOrder;
    private javax.swing.JButton btnSEmploy;
    private javax.swing.JToggleButton btnSearch;
    private javax.swing.JComboBox<String> cmbSort;
    private javax.swing.JComboBox<String> cmbSortEmploy;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtblStaff;
    private javax.swing.JTable jtblStaffUn;
    private javax.swing.JTable jtblStock;
    private javax.swing.JTable tblUnAuthStock;
    private javax.swing.JTabbedPane tbpAdmin;
    private javax.swing.JTextField txtSEmploy;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
