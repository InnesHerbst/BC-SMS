/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Marline
 */
public class StockService implements IStock, Serializable {

    public List<Stock> DisplayStock() {
        return Stock.DisplayStock();
    }

    public void UpdateStock(int id, int quantity, String name) {
        Stock.UpdateStock(id, quantity, name);

    }

    public void DeleteStock(int id, String name) {
        Stock.DisplayStock();

    }

    public void AddStock(int prodID, int ProdQuant, int deptID, int campID) {
        Stock.AddStock(prodID, ProdQuant, deptID, campID);
    }

    public List<Stock> UpdateView(int id) {
        return Stock.UpdateView(id);
    }
}
