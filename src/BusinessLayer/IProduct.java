/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Marline
 */
public interface IProduct extends Remote {

    Product UpdateView(int id) throws RemoteException;

    void AddProduct(String prodName, double prodPrice, int catID) throws RemoteException;

    void UpdateProduct(int id, int quantity, String name) throws RemoteException;

    void DeleteProduct(int id, String name) throws RemoteException;
}
