/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Marline
 */
public class StockService extends UnicastRemoteObject implements IStock, Serializable {

    public StockService() throws RemoteException {
        super();
    }

    public List<Stock> DisplayStock() {
        return Stock.DisplayStock();
    }

    public void UpdateStock(int id, int quantity, String name) {
        Stock.UpdateStock(id, quantity, name);

    }

    public void DeleteStock(int id, String name) {
        Stock.DisplayStock();

    }

    public void AddStock(int prodID, int ProdQuant, int deptID, int campID, String confirmValue) {
        Stock.AddStock(prodID, ProdQuant, deptID, campID, confirmValue);
    }

    public List<Stock> UpdateView(int id) {
        return Stock.UpdateView(id);
    }
}
