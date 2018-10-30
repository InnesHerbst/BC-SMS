/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.rmi.Remote;
import java.util.List;

/**
 *
 * @author Marline
 */
public interface IStaff extends Remote{
    
     String[] signIn(String username, char[] password);

    String[] registerStaff(Staff nStaff);

    List<Staff> fetchStaffData();

    List<Staff> fetchUnAuthStaffData();

    String[] authStaff(String sID);

    void DeleteStaff(String id);
}
