package BusinessLayer;

import java.util.Date;

/**
 *
 * @author Marline
 */
public class Staff {

    private int staff_ID;
    private String staff_initials;
    private String staff_firstname;
    private String staff_lastname;
    private Date staff_dob;
    private int staff_gender;
    private int staff_phone;
    private String staff_email;
    private String staff_password;
    private String staff_address1;
    private String staff_address2;

    public Staff(int staff_ID, String staff_initials, String staff_firstname, String staff_lastname, Date staff_dob, int staff_gender, int staff_phone, String staff_email, String staff_password, String staff_address1, String staff_address2) {
        this.staff_ID = staff_ID;
        this.staff_initials = staff_initials;
        this.staff_firstname = staff_firstname;
        this.staff_lastname = staff_lastname;
        this.staff_dob = staff_dob;
        this.staff_gender = staff_gender;
        this.staff_phone = staff_phone;
        this.staff_email = staff_email;
        this.staff_password = staff_password;
        this.staff_address1 = staff_address1;
        this.staff_address2 = staff_address2;
    }

    public int getStaff_ID() {
        return staff_ID;
    }

    public String getStaff_initials() {
        return staff_initials;
    }

    public String getStaff_firstname() {
        return staff_firstname;
    }

    public String getStaff_lastname() {
        return staff_lastname;
    }

    public Date getStaff_dob() {
        return staff_dob;
    }

    public int getStaff_gender() {
        return staff_gender;
    }

    public int getStaff_phone() {
        return staff_phone;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public String getStaff_password() {
        return staff_password;
    }

    public String getStaff_address1() {
        return staff_address1;
    }

    public String getStaff_address2() {
        return staff_address2;
    }

    public void setStaff_ID(int staff_ID) {
        this.staff_ID = staff_ID;
    }

    public void setStaff_initials(String staff_initials) {
        this.staff_initials = staff_initials;
    }

    public void setStaff_firstname(String staff_firstname) {
        this.staff_firstname = staff_firstname;
    }

    public void setStaff_lastname(String staff_lastname) {
        this.staff_lastname = staff_lastname;
    }

    public void setStaff_dob(Date staff_dob) {
        this.staff_dob = staff_dob;
    }

    public void setStaff_gender(int staff_gender) {
        this.staff_gender = staff_gender;
    }

    public void setStaff_phone(int staff_phone) {
        this.staff_phone = staff_phone;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }

    public void setStaff_password(String staff_password) {
        this.staff_password = staff_password;
    }

    public void setStaff_address1(String staff_address1) {
        this.staff_address1 = staff_address1;
    }

    public void setStaff_address2(String staff_address2) {
        this.staff_address2 = staff_address2;
    }

}
