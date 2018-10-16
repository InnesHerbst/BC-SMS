/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.util.Date;

/**
 *
 * @author Adria
 */
public class Admin {
    private String Admin_ID;
    private String Admin_First_Name;
    private String Admin_Initials;
    private String Admin_Last_Name;
    private Date Admin_DoB;
    private String Admin_Gender;
    private String Admin_Phone;
    private String Admin_Email;
    private String Admin_Password;
    private String Admin_Address_1 ;
    private String Admin_Address_2 ;
    private int Campus_ID;

    public String getAdmin_ID() {
        return Admin_ID;
    }

    public void setAdmin_ID(String Admin_ID) {
        this.Admin_ID = Admin_ID;
    }

    public String getAdmin_First_Name() {
        return Admin_First_Name;
    }

    public void setAdmin_First_Name(String Admin_First_Name) {
        this.Admin_First_Name = Admin_First_Name;
    }

    public String getAdmin_Initials() {
        return Admin_Initials;
    }

    public void setAdmin_Initials(String Admin_Initials) {
        this.Admin_Initials = Admin_Initials;
    }

    public String getAdmin_Last_Name() {
        return Admin_Last_Name;
    }

    public void setAdmin_Last_Name(String Admin_Last_Name) {
        this.Admin_Last_Name = Admin_Last_Name;
    }

    public Date getAdmin_DoB() {
        return Admin_DoB;
    }

    public void setAdmin_DoB(Date Admin_DoB) {
        this.Admin_DoB = Admin_DoB;
    }

    public String getAdmin_Gender() {
        return Admin_Gender;
    }

    public void setAdmin_Gender(String Admin_Gender) {
        this.Admin_Gender = Admin_Gender;
    }

    public String getAdmin_Phone() {
        return Admin_Phone;
    }

    public void setAdmin_Phone(String Admin_Phone) {
        this.Admin_Phone = Admin_Phone;
    }

    public String getAdmin_Email() {
        return Admin_Email;
    }

    public void setAdmin_Email(String Admin_Email) {
        this.Admin_Email = Admin_Email;
    }

    public String getAdmin_Password() {
        return Admin_Password;
    }

    public void setAdmin_Password(String Admin_Password) {
        this.Admin_Password = Admin_Password;
    }

    public String getAdmin_Address_1() {
        return Admin_Address_1;
    }

    public void setAdmin_Address_1(String Admin_Address_1) {
        this.Admin_Address_1 = Admin_Address_1;
    }

    public String getAdmin_Address_2() {
        return Admin_Address_2;
    }

    public void setAdmin_Address_2(String Admin_Address_2) {
        this.Admin_Address_2 = Admin_Address_2;
    }

    public int getCampus_ID() {
        return Campus_ID;
    }

    public void setCampus_ID(int Campus_ID) {
        this.Campus_ID = Campus_ID;
    }

    public Admin(String Admin_ID, String Admin_First_Name, String Admin_Initials, String Admin_Last_Name, Date Admin_DoB, String Admin_Gender, String Admin_Phone, String Admin_Email, String Admin_Password, String Admin_Address_1, String Admin_Address_2, int Campus_ID) {
        this.Admin_ID = Admin_ID;
        this.Admin_First_Name = Admin_First_Name;
        this.Admin_Initials = Admin_Initials;
        this.Admin_Last_Name = Admin_Last_Name;
        this.Admin_DoB = Admin_DoB;
        this.Admin_Gender = Admin_Gender;
        this.Admin_Phone = Admin_Phone;
        this.Admin_Email = Admin_Email;
        this.Admin_Password = Admin_Password;
        this.Admin_Address_1 = Admin_Address_1;
        this.Admin_Address_2 = Admin_Address_2;
        this.Campus_ID = Campus_ID;
    }

    @Override
    public String toString() {
        return "Admin{" + "Admin_ID=" + Admin_ID + ", Admin_First_Name=" + Admin_First_Name + ", Admin_Initials=" + Admin_Initials + ", Admin_Last_Name=" + Admin_Last_Name + ", Admin_DoB=" + Admin_DoB + ", Admin_Gender=" + Admin_Gender + ", Admin_Phone=" + Admin_Phone + ", Admin_Email=" + Admin_Email + ", Admin_Password=" + Admin_Password + ", Admin_Address_1=" + Admin_Address_1 + ", Admin_Address_2=" + Admin_Address_2 + ", Campus_ID=" + Campus_ID + '}';
    }
    
    public void Regester_admin(Admin adm)
    {
        
    }
}
