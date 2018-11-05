/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Marline
 */
public interface IStaff extends Remote {

    Object[] signIn(String username, char[] password) throws RemoteException;

    String[] registerStaff(Staff nStaff) throws RemoteException;

    List<Staff> fetchStaffData() throws RemoteException;

    List<Staff> fetchUnAuthStaffData() throws RemoteException;

    String[] authStaff(String sID) throws RemoteException;

    String[] UpdateStaff(String sID, Staff nStaff) throws RemoteException;

    void DeleteStaff(String id) throws RemoteException;
}
