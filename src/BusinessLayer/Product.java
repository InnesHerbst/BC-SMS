package BusinessLayer;

import DataLayer.ProductDataHandler;
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
public class Product {

    private int prodID;
    private String prodName;
    private double prodPrice;
    private int prodQty;
    private ProductDataHandler dbConn;

    public Product(int prodID, String prodName, double prodPrice, int prodQty) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodQty = prodQty;
        this.dbConn = new ProductDataHandler();
    }

    public int getProdID() {
        return prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public int getProdQty() {
        return prodQty;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public void setProdQty(int prodQty) {
        this.prodQty = prodQty;
    }

//    public Product getProduct(int id) throws ClassNotFoundException, SQLException {
//        Product stock = dbConn.GetProduct(getProdID());
//        return stock;
//    }
//
//    public boolean addStock() throws SQLException, ClassNotFoundException {
//        return dbConn.InsertProduct(this);
//    }
//
//    public boolean updateStock() throws SQLException, ClassNotFoundException {
//        return dbConn.UpdateProduct(this);
//    }
//
//    public boolean removeStock() throws SQLException, ClassNotFoundException {
//        return dbConn.DeleteProduct(getProdID());
//    }
    public static List<Product> DisplayProduct() {
        List<Product> lst = new ArrayList<>();
        try {
            lst = ProductDataHandler.getInstance().fetchProductData();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    public static List<Product> UpdateView(int id) {
        List<Product> lst = new ArrayList<>();
        try {
            lst = ProductDataHandler.getInstance().viewProductData(id);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public static void UpdateProduct(int id, int quantity, String name) {

        try {
            ProductDataHandler.getInstance().updateProduct(id, quantity);
            JOptionPane.showMessageDialog(null, "Product " + name + " Updated", "Update", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void DeleteProduct(int id, String name) {
        try {
            ProductDataHandler.getInstance().deleteProduct(id);
            JOptionPane.showMessageDialog(null, "Product " + name + " Deleted", "Delete", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void AddProduct(String prodName, double prodPrice, int catID) {
        try {
            ProductDataHandler.getInstance().addProduct(prodName, prodPrice, catID);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "Product{" + "prodID=" + prodID + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodQty=" + prodQty + '}';
    }

    public Product() {
    }
}
