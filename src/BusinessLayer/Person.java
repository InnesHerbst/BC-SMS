package BusinessLayer;

import java.util.Date;

/**
 *
 * @author Innes Herbst
 */
public abstract class Person {

    private String p_ID;
    private String p_initials;
    private String p_firstname;
    private String p_lastname;
    private Date p_dob;
    private String p_gender;
    private String p_phone;
    private String p_email;
    private char[] p_password;
    private String p_address1;
    private String p_address2;

    public String getP_ID() {
        return p_ID;
    }

    public void setP_ID(String p_ID) {
        this.p_ID = p_ID;
    }

    public String getP_initials() {
        return p_initials;
    }

    public void setP_initials(String p_initials) {
        this.p_initials = p_initials;
    }

    public String getP_firstname() {
        return p_firstname;
    }

    public void setP_firstname(String p_firstname) {
        this.p_firstname = p_firstname;
    }

    public String getP_lastname() {
        return p_lastname;
    }

    public void setP_lastname(String p_lastname) {
        this.p_lastname = p_lastname;
    }

    public Date getP_dob() {
        return p_dob;
    }

    public void setP_dob(Date p_dob) {
        this.p_dob = p_dob;
    }

    public String getP_gender() {
        return p_gender;
    }

    public void setP_gender(String p_gender) {
        this.p_gender = p_gender;
    }

    public String getP_phone() {
        return p_phone;
    }

    public void setP_phone(String p_phone) {
        this.p_phone = p_phone;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public char[] getP_password() {
        return p_password;
    }

    public void setP_password(char[] p_password) {
        this.p_password = p_password;
    }

    public String getP_address1() {
        return p_address1;
    }

    public void setP_address1(String p_address1) {
        this.p_address1 = p_address1;
    }

    public String getP_address2() {
        return p_address2;
    }

    public void setP_address2(String p_address2) {
        this.p_address2 = p_address2;
    }

    public Person(String p_ID, String p_initials, String p_firstname, String p_lastname, Date p_dob, String p_gender, String p_phone, String p_email, char[] p_password, String p_address1, String p_address2) {
        this.p_ID = p_ID;
        this.p_initials = p_initials;
        this.p_firstname = p_firstname;
        this.p_lastname = p_lastname;
        this.p_dob = p_dob;
        this.p_gender = p_gender;
        this.p_phone = p_phone;
        this.p_email = p_email;
        this.p_password = p_password;
        this.p_address1 = p_address1;
        this.p_address2 = p_address2;
    }

    @Override
    public String toString() {
        return "Person{" + "p_ID=" + p_ID + ", p_initials=" + p_initials + ", p_firstname=" + p_firstname + ", p_lastname=" + p_lastname + ", p_dob=" + p_dob + ", p_gender=" + p_gender + ", p_phone=" + p_phone + ", p_email=" + p_email + ", p_password=" + p_password + ", p_address1=" + p_address1 + ", p_address2=" + p_address2 + '}';
    }

}
