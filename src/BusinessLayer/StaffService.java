/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.util.List;

/**
 *
 * @author Marline
 */
public class StaffService implements IStaff{
    //This class implements the methods of the staff class for the interface.

    public Object[] signIn(String username, char[] password) {
        return Staff.signIn(username, password);
    }

    public String[] registerStaff(Staff nStaff) {
        return Staff.registerStaff(nStaff);
    }

    public List<Staff> fetchStaffData() {
        return Staff.fetchStaffData();
    }

    public List<Staff> fetchUnAuthStaffData() {
        return Staff.fetchUnAuthStaffData();
    }

    public String[] authStaff(String sID) {
        return Staff.authStaff(sID);
    }

    public void DeleteStaff(String id) {
        Staff.DeleteStaff(id);
    }
}
