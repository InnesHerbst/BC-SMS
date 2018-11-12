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
public interface IStock extends Remote {

    List<Stock> DisplayStock() throws RemoteException;

    List<Stock> UpdateView(int id) throws RemoteException;

    void UpdateStock(int id, int quantity, String name) throws RemoteException;

    void DeleteStock(int id, String name) throws RemoteException;

    void AddStock(int prodID, int ProdQuant, int deptID, int campID, String confirmValue) throws RemoteException;
}
