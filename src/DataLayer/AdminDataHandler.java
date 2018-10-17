/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import BusinessLayer.Admin;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author Innes Herbst
 */
public class AdminDataHandler extends ConnectionHandler {

    private static AdminDataHandler adminDataHandler;

    public AdminDataHandler() {
        super();
    }

    public static AdminDataHandler getInnstance() {
        if (adminDataHandler == null) {
            adminDataHandler = new AdminDataHandler();
        }

        return adminDataHandler;
    }

    public String[] SignIn(String username, char[] password) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement sCMD = null;

        if (ConnectDatabase()) {
            try {
                sCMD = getDbConnection().prepareStatement("Select Admin_Email,Admin_Password from Administrator where Admin_Email = ?");
                sCMD.setString(1, username);
                ResultSet result = sCMD.executeQuery();
                arg[0] = "null";
                arg[1] = "null";

                while (result.next()) {
                    String uEmail = result.getString("Admin_Email");
                    System.out.println(uEmail);
                    char[] uPWord = result.getString("Admin_Password").toCharArray();
                    System.out.println(Arrays.toString(uPWord));
                    
                    //char[] uPassword = uPWord.toCharArray();
                    //Changed the method to accomadate the password textfields.
                    System.out.println("Data Handler : "+uEmail.trim().toUpperCase()+" , "+username.trim().toUpperCase());
                    System.out.println(uEmail.trim().toUpperCase().equals(username.trim().toUpperCase()));
                    boolean matches = true;
                    if (uEmail.trim().toUpperCase().equals(username.trim().toUpperCase())) {
                        System.out.println("IT WENT IN");
                        
                        
                        
                        for (int i = 0; i < uPWord.length; i++) {
                            if(uPWord[i] != password[i]){
                                matches = false;
                            }
                        }
                        
                        
                        if (matches) {
                            //Set the return type to success
                            arg[0] = "Success";
                            arg[1] = "User Can Sign In";
                        } else {
                            arg[0] = "Error - Password";
                            arg[1] = "Password Incorrect";
                        }
                        
                        System.out.println(Arrays.toString(arg));
                    }
                }

                if (!arg[0].equals("Success") && !arg[0].equals("Error - Password")) {
                    arg[0] = "Error - User";
                    arg[1] = "User Not Found";
                }

            } catch (SQLException e) {
                arg[0] = "Error - Database";
                arg[1] = e.getMessage();
            } finally {
                if (sCMD != null) {
                    sCMD.close();
                }
                DisconnectDatabase();
            }

        } else {
            //Set the return type an error
            arg[0] = "Error - Database";
            arg[1] = "Database could not connect";
        }

        return arg;
    }

    public String[] register(Admin nAdmin) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement iCMD = null;

        try {
            StringBuilder uPassword = new StringBuilder();
            for (int i = 0; i < nAdmin.getP_password().length; i++) {
                uPassword.append(nAdmin.getP_password()[i]);
            }
            if (ConnectDatabase()) {
                iCMD = getDbConnection().prepareStatement("INSERT INTO Administrator VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
                iCMD.setString(1, nAdmin.getP_ID());
                iCMD.setString(2, nAdmin.getP_firstname());
                iCMD.setString(3, nAdmin.getP_initials());
                iCMD.setString(4, nAdmin.getP_lastname());
                iCMD.setDate(5, (Date) nAdmin.getP_dob());
                iCMD.setString(6, nAdmin.getP_gender());
                iCMD.setString(7, nAdmin.getP_phone());
                iCMD.setString(8, nAdmin.getP_email());
                iCMD.setString(9, uPassword.toString());
                iCMD.setString(10, nAdmin.getP_address1());
                iCMD.setString(11, nAdmin.getP_address2());
                iCMD.setInt(12, nAdmin.getCampus_ID());

                int count = iCMD.executeUpdate();

                if (count < 1) {
                    arg[0] = "Error - SQL";
                    arg[1] = "Insert statement Incorrect";
                } else {
                    arg[0] = "Success";
                    arg[1] = "Insert statement success.";
                }

            } else {
                arg[0] = "Error - Database";
                arg[1] = "Database Could Not Connect";
            }
        } catch (SQLException e) {
        } finally {
            if (iCMD != null) {
                iCMD.close();
            }

            DisconnectDatabase();
        }

        return arg;
    }        

}
