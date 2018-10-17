package BusinessLayer;

import DataLayer.AdminDataHandler;
import DataLayer.StockDataHandler;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Adria
 */
public class Stock {

    private int id;
    private String name;
    private double price;
    private int quantity;
    private String category;
    private String description;
//    private StockDataHandler dbConn; //for StockDataHandler

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public StockDataHandler getDbConn() {                 //for StockDataHandler
//        return dbConn;
//    }
//
//    public void setDbConn(StockDataHandler dbConn) {
//        this.dbConn = dbConn;
//    }
    public Stock(int id, String name, double price, int quantity, String category, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
//        this.dbConn = new StockDataHandler();     //for StockDataHandler
    }

    public List<Stock> DisplayStock() {

        
        List<Stock> lst = new ArrayList<>();
        try {
            lst = StockDataHandler.getInstance().fetchStockData();
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        //lst.add(new Stock(2, "Gold", 38.52, 2, "Jewl", "Yellow"));
        return lst;
    }

    public List<Stock> UpdateView(int id) {
        List<Stock> lst = new ArrayList<>();
        try {
            lst = StockDataHandler.getInstance().viewStockData(id);
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lst;
    }

    public static void UpdateStock(int id, int quantity, String name) {
        
        try {
            StockDataHandler.getInstance().updateStock(id,quantity);
        JOptionPane.showMessageDialog(null, "Stock " + name + " Updated", "Update", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public Stock getStock(int id) throws ClassNotFoundException, SQLException {       //for StockDataHandler
//        Stock stock = dbConn.GetStock(id);
//        return stock;
//    }
//
//    public boolean addStock() throws SQLException, ClassNotFoundException {
//        return dbConn.InsertStock(this);
//    }
//
//    public boolean updateStock() throws SQLException, ClassNotFoundException {
//        return dbConn.UpdateStock(this);
//    }
//
//    public boolean removeStock() throws SQLException, ClassNotFoundException {
//        return dbConn.DeleteStock(Integer.parseInt(getProduct_ID()));
//    }
    public void DeleteStock(int id, String name) {
        try {
            StockDataHandler.getInstance().deleteStock(id);
        JOptionPane.showMessageDialog(null, "Stock " + name + " Deleted", "Delete", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void AddStock(int prodID, int ProdQuant, int deptID, int campID) {
        try {
            StockDataHandler.getInstance().addStock(prodID, ProdQuant, deptID, campID);
            //JOptionPane.showMessageDialog(null, "Stock " + name + " Added", "Add", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
