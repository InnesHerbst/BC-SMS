/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataLayer.StockDataHandler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marline
 */
public class StockService implements IStock{

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
