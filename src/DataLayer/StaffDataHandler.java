/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import BusinessLayer.Staff;
import java.sql.Connection;
import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Innes Herbst
 */
public class StaffDataHandler extends ConnectionHandler {

    //Singleton Implementation
    private static StaffDataHandler staffDataHandler;

    public StaffDataHandler() {
        super();
    }

    public static StaffDataHandler getInstance() {
        if (staffDataHandler == null) {
            staffDataHandler = new StaffDataHandler();
        }

        return staffDataHandler;
    }

    public String[] SignIn(String username, char[] password) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement sCMD = null;

        if (ConnectDatabase()) {
            try {
                sCMD = getDbConnection().prepareStatement("Select EMAIL,PASSWORD from Staff where Staff_Email = ?");
                sCMD.setString(1, username);
                ResultSet result = sCMD.executeQuery();

                while (result.next()) {
                    String uEmail = result.getString("Staff_Email");
                    char[] uPWord = result.getString("Staff_Password").toCharArray();

                    if (uEmail.toUpperCase().equals(username.toUpperCase())) {
                        if (Arrays.equals(uPWord, password)) {
                            //Set the return type to success
                            arg[0] = "Success";
                            arg[1] = "User Can Sign In";
                        } else {
                            arg[0] = "Error - Password";
                            arg[1] = "Password Incorrect";
                        }
                    }
                }

                if (!arg[0].equals("Success") || !arg[0].equals("Error - Password")) {
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

        DisconnectDatabase();

        return arg;
    }

    public String[] Register(Staff nStaff) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement iCMD = null;

        if (ConnectDatabase()) {
            StringBuilder uPassword = new StringBuilder();
            for (int i = 0; i < nStaff.getP_password().length; i++) {
                uPassword.append(nStaff.getP_password()[i]);
            }
            try {
                iCMD = getDbConnection().prepareStatement("INSERT INTO Registration VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                iCMD.setString(1, nStaff.getP_ID());
                iCMD.setString(2, nStaff.getP_firstname());
                iCMD.setString(3, nStaff.getP_initials());
                iCMD.setString(4, nStaff.getP_lastname());
                iCMD.setDate(5, (Date) nStaff.getP_dob());
                iCMD.setString(6, nStaff.getP_gender());
                iCMD.setString(7, nStaff.getP_phone());
                iCMD.setString(8, nStaff.getP_email());
                iCMD.setString(9, nStaff.getP_address1());
                iCMD.setString(10, nStaff.getP_address2());
                iCMD.setInt(11, nStaff.getCampus_id());
                iCMD.setInt(12, nStaff.getDepartment_id());
                iCMD.setString(13, uPassword.toString());

                int count = iCMD.executeUpdate();

                if (count < 1) {
                    arg[0] = "Error - SQL";
                    arg[1] = "Insert Statement Incorrect";
                } else {
                    arg[0] = "Success";
                    arg[1] = "Insert Statement success";
                }

            } catch (SQLException e) {
                arg[0] = "Error - Database";
                arg[1] = e.getMessage();
            } finally {
                if (iCMD != null) {
                    iCMD.close();
                }
                DisconnectDatabase();
            }

        } else {
            arg[0] = "Error - Database";
            arg[1] = "Database Could Not Connect";
        }

        return arg;
    }

    public List<Staff> fetchStaffData() throws SQLException {
        List<Staff> staff = new ArrayList<>();
        PreparedStatement sCMD = null;

        try {
            if (ConnectDatabase()) {
                sCMD = getDbConnection().prepareStatement("SELECT * FROM Staff");

                ResultSet result = sCMD.executeQuery();

                while (result.next()) {
                    String sID = result.getString("Staff_ID");
                    String sName = result.getString("Staff_First_Name");
                    String sIni = result.getString("Staff_Initials");
                    String sLName = result.getString("Staff_Last_Name");
                    Date sDoB = result.getDate("Staff_DoB");
                    String sGender = result.getString("Staff_Gender");
                    String sPhone = result.getString("Staff_Phone");
                    String sEmail = result.getString("Staff_Email");
                    String sAddr1 = result.getString("Staff_Address_1");
                    String sAddr2 = result.getString("Staff_Address_2");
                    int sCampID = result.getInt("Staff_Campus_ID");
                    int sDepID = result.getInt("Staff_Department_ID");
                    String sPWord = result.getString("Staff_Password");

                    staff.add(new Staff(sCampID, sDepID, sID, sIni, sName, sLName, sDoB, sGender, sPhone, sEmail, sPWord.toCharArray(), sAddr1, sAddr2));
                }

            }
        } catch (SQLException e) {
            System.out.println("Problem Occured : " + e.getMessage());
        } finally {
            if (sCMD != null) {
                sCMD.close();
            }
            DisconnectDatabase();
        }

        return staff;
    }

    public String[] UpdateStaff(String sID, Staff nStaff) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement iCMD = null;
        try {
            if (ConnectDatabase()) {
                StringBuilder uPassword = new StringBuilder();
                for (int i = 0; i < nStaff.getP_password().length; i++) {
                    uPassword.append(nStaff.getP_password()[i]);
                }

                iCMD = getDbConnection().prepareStatement("UPDATE Staff SET "
                        + "Staff_ID = ?, "
                        + "Staff_First_Name = ?, "
                        + "Staff_Initials = ?, "
                        + "Staff_Last_Name = ?, "
                        + "Staff_DoB = ?, "
                        + "Staff_Gender = ?, "
                        + "Staff_Phone = ?, "
                        + "Staff_Email = ?, "
                        + "Staff_Address = ?, "
                        + "Staff_Address = 'null', "
                        + "Staff_Campus_ID = ?, "
                        + "Staff_Department_ID = ?, "
                        + "Staff_Password = ? "
                        + "WHERE Staff_ID = ?;");
                iCMD.setString(1, nStaff.getP_ID());
                iCMD.setString(2, nStaff.getP_firstname());
                iCMD.setString(3, nStaff.getP_initials());
                iCMD.setString(4, nStaff.getP_lastname());
                iCMD.setDate(5, (Date) nStaff.getP_dob());
                iCMD.setString(6, nStaff.getP_gender());
                iCMD.setString(7, nStaff.getP_phone());
                iCMD.setString(8, nStaff.getP_email());
                iCMD.setString(9, nStaff.getP_address1());
                iCMD.setString(10, nStaff.getP_address2());
                iCMD.setInt(11, nStaff.getCampus_id());
                iCMD.setInt(12, nStaff.getDepartment_id());
                iCMD.setString(13, uPassword.toString());
                iCMD.setString(14, nStaff.getP_ID());

                int done = iCMD.executeUpdate();
                if (done < 0) {
                    arg[0] = "Error - SQL";
                    arg[1] = "Update Statement Incorrect";
                } else {
                    arg[0] = "Success";
                    arg[1] = "Update Statement Correct";
                }
            } else {
                arg[0] = "Error - Database";
                arg[1] = "Database Could Not Connect.";
            }

        } catch (SQLException e) {
            arg[0] = "Error - SQL";
            arg[1] = e.getMessage();
        } finally {
            if (iCMD != null) {
                iCMD.close();
            }

            DisconnectDatabase();
        }

        return arg;
    }

    public String[] DeleteStaff(String id) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement dCMD = null;

        if (ConnectDatabase()) {
            try {
                dCMD = getDbConnection().prepareStatement("DELTE FROM Staff WHERE Staff_ID = ?;");
                dCMD.setString(1, id);

                int count = dCMD.executeUpdate();

                if (count < 1) {
                    arg[0] = "Error - SQL";
                    arg[1] = "Delete Statement Incorrect";
                } else {
                    arg[0] = "Success";
                    arg[1] = "Delete Statement Incorrect";
                }
            } catch (SQLException e) {
                arg[0] = "Error - SQL";
                arg[1] = e.getMessage();
            } finally {
                if (dCMD != null) {
                    dCMD.close();
                }

                DisconnectDatabase();
            }

        } else {
            arg[0] = "Error - Database";
            arg[1] = "Database Could Not Connect.";
        }

        return arg;

    }

}
