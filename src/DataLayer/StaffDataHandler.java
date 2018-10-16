/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import BusinessLayer.Staff;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

/**
 *
 * @author Innes Herbst
 */
public class StaffDataHandler extends ConnectionHandler {

    //Singleton Implementation
    
    private static StaffDataHandler staffDataHandler;

    private StaffDataHandler() {
        super();
    }

    public static StaffDataHandler getInstance() {
        if(staffDataHandler == null){
            staffDataHandler = new StaffDataHandler();
        }

        return staffDataHandler;
    }  
    
    public String[] SignIn(String username,String password){
        String[] arg = new String[2];
        
        if(ConnectDatabase()){
            try {
                PreparedStatement sCMD = getDbConnection().prepareStatement("Select EMAIL,PASSWORD from tblStaff where EMAIL = ?");
                sCMD.setString(1, username);
                ResultSet result = sCMD.executeQuery();
                
                result.first();
                
                while (result.next()) {
                    String uEmail = result.getString("EMAIL");
                    String uPWord = result.getString("PASSWORD");
                    
                    if(uEmail.toUpperCase().equals(username.toUpperCase())){
                        if(uPWord.equals(password)){
                            //Set the return type to success
                            arg[0] = "Success";
                            arg[1] = "User Can Sign In";
                        }else{
                            arg[0] = "Error - Password";
                            arg[1] = "Password Incorrect";
                        }
                    }                    
                }
                
                if(!arg[0].equals("Success") || !arg[0].equals("Error - Password")){
                    arg[0] = "Error - User";
                    arg[1] = "User Not Found";
                }
                
            } catch (SQLException e) {
                arg[0] = "Error - Database";
                arg[1] = e.getMessage();
            }            
        }else{
            //Set the return type an error
            arg[0] = "Error - Database";
            arg[1] = "Database could not connect";
        }
        
        DisconnectDatabase();
        
        return arg;
    }
    
    public String[] Register(Staff nStaff){
        String[] arg = new String[2];
        
        if(ConnectDatabase()){
            try {
                PreparedStatement iCMD = getDbConnection().prepareStatement("INSERT INTO tblRegister VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                iCMD.setString(1, nStaff);
                iCMD.setString(2, nStaff);
                iCMD.setString(3, nStaff);
                iCMD.setString(4, nStaff);
                iCMD.setDate(5, (Date) nStaff);
                iCMD.setString();
                //Still Busy
                
                iCMD.executeQuery();
            } catch (SQLException e) {
                arg[0] = "Error - Database";
                arg[1] = e.getMessage();
            }
            
        }else{
            arg[0] = "Error - Database";
            arg[1] = "Database Could Not Connect";
        }
        
        return arg;
    }

}
