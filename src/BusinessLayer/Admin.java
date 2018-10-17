
package BusinessLayer;

import DataLayer.AdminDataHandler;
import DataLayer.StaffDataHandler;
import java.sql.SQLException;
import java.util.Date;

import java.util.Date;

/**
 *
 * @author Adria
 */
public class Admin extends Person{
    private int Campus_ID;

    public Admin(int Campus_ID, String p_ID, String p_initials, String p_firstname, String p_lastname, Date p_dob, String p_gender, String p_phone, String p_email, String p_password, String p_address1, String p_address2) {
        super(p_ID, p_initials, p_firstname, p_lastname, p_dob, p_gender, p_phone, p_email, p_password, p_address1, p_address2);
        this.Campus_ID = Campus_ID;
    }

    

    public int getCampus_ID() {
        return Campus_ID;
    }

    public void setCampus_ID(int Campus_ID) {
        this.Campus_ID = Campus_ID;
    }

    
    public static String[] signIn(String username,char[] password){
        String[] result = null;
        try {
            result = AdminDataHandler.getInnstance().SignIn(username, password);
        } catch (SQLException e) {
            System.out.println("Problem Occured : "+e.getMessage());
        }
        
        return result;
    }
    
    public static String[] registerStaff(Admin nAdmin){
        String[] result = null;
        
        try {
            result = AdminDataHandler.getInnstance().register(nAdmin);
        } catch (SQLException e) {
            System.out.println("Problem Occured : "+e.getMessage());
        }
        
        return result;
    }
}
