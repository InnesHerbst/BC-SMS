package BusinessLayer;

import java.util.Date;

/**
 *
 * @author Marline
 */
public class Staff extends Person{

    public Staff(int campus_id, int department_id, String p_ID, String p_initials, String p_firstname, String p_lastname, Date p_dob, String p_gender, String p_phone, String p_email, String p_password, String p_address1, String p_address2) {
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
    
    

   

}
