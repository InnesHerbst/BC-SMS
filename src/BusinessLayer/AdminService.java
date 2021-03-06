/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Marline
 */
public class AdminService extends UnicastRemoteObject implements IAdmin, Serializable {

    public AdminService() throws RemoteException {
        super();
    }

    @Override
    public String[] signIn(String username, char[] password) {
        return Admin.signIn(username, password);
    }

    @Override
    public String[] registerAdmin(Admin nAdmin) {
        return Admin.registerAdmin(nAdmin);
    }

}
