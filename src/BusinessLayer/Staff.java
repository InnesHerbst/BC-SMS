package BusinessLayer;

import DataLayer.StaffDataHandler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marline
 */
public class Staff extends Person {

    public Staff(int campus_id, int department_id, String p_ID, String p_initials, String p_firstname, String p_lastname, Date p_dob, String p_gender, String p_phone, String p_email, char[] p_password, String p_address1, String p_address2) {
        super(p_ID, p_initials, p_firstname, p_lastname, p_dob, p_gender, p_phone, p_email, p_password, p_address1, p_address2);
        this.campus_id = campus_id;
        this.department_id = department_id;
    }

    private int campus_id;
    private int department_id;

    public int getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(int campus_id) {
        this.campus_id = campus_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    //Can not use these, as a staff object has to be made before accessing them.
//    private StaffDataHandler dbConn = new StaffDataHandler();
//
//    public List<Staff> getAll() throws Exception {
//        return this.dbConn.fetchStaffData();
//    }
//
//    public String[] SignIn(String username, String password) throws Exception {
//        String[] staff = dbConn.SignIn(username, password);
//        if (staff == null) {
//            throw new RuntimeException("Login Failed!");
//        }
//        return staff;
//    }
//
//    public Staff getStaff() throws ClassNotFoundException, SQLException {
//        Staff staff = dbConn.GetStaff(Integer.parseInt((getP_ID())));
//        return staff;
//    }
//
//    public String[] addStaff() throws SQLException, ClassNotFoundException {
//        return dbConn.Register(this);
//    }
//
//    public boolean changeStaff() throws SQLException, ClassNotFoundException {
//        return dbConn.UpdateStaff(this);
//    }
//
//    public boolean removeStaff() throws SQLException, ClassNotFoundException {
//        return dbConn.DeleteStaff(Integer.parseInt((getP_ID())));
//    }
    public static String[] signIn(String username, char[] password) {
        String[] result = null;
        try {
            result = StaffDataHandler.getInstance().SignIn(username, password);
        } catch (SQLException e) {
            System.out.println("Problem Occured : " + e.getMessage());
        }

        return result;
    }

    public static String[] registerStaff(Staff nStaff) {
        String[] result = null;

        try {
            result = StaffDataHandler.getInstance().Register(nStaff);
        } catch (SQLException e) {
            System.out.println("Problem Occured : " + e.getMessage());
        }

        return result;
    }

    public static List<Staff> fetchStaffData() {
        List<Staff> staff = new ArrayList<>();
        try {
            staff = StaffDataHandler.getInstance().fetchStaffData();
        } catch (SQLException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return staff;
    }
    
    public static List<Staff> fetchUnAuthStaffData() {
        List<Staff> staff = new ArrayList<>();
        try {
            staff = StaffDataHandler.getInstance().getUnAuthStaff();
        } catch (SQLException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return staff;
    }
    
    public static String[] authStaff(String sID){
        String[] result = null;
        
        try {
            result = StaffDataHandler.getInstance().authStaff(sID);
        } catch (SQLException e) {
            System.out.println("");
        }
        
        return result;
    }
    
    public static void DeleteStaff(String id){
        try {
            StaffDataHandler sd = new StaffDataHandler();
            sd.DeleteStaff(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
