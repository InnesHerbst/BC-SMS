/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataLayer.AdminDataHandler;
import java.rmi.Remote;
import java.sql.SQLException;

/**
 *
 * @author Marline
 */
public interface IAdmin extends Remote{
    
    String[] signIn(String username,char[] password);
    
    String[] registerAdmin(Admin nAdmin);
}
