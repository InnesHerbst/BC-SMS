package BusinessLayer;

import DataLayer.ProductDataHandler;
import java.sql.SQLException;

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

    public Product getProduct(int id) throws ClassNotFoundException, SQLException {
        Product stock = dbConn.GetProduct(getProdID());
        return stock;
    }

    public boolean addStock() throws SQLException, ClassNotFoundException {
        return dbConn.InsertProduct(this);
    }

    public boolean updateStock() throws SQLException, ClassNotFoundException {
        return dbConn.UpdateProduct(this);
    }

    public boolean removeStock() throws SQLException, ClassNotFoundException {
        return dbConn.DeleteProduct(getProdID());
    }

    @Override
    public String toString() {
        return "Product{" + "prodID=" + prodID + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodQty=" + prodQty + '}';
    }

}
