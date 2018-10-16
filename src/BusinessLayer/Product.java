package BusinessLayer;

/**
 *
 * @author Marline
 */
public class Product {

    private int prodID;
    private String prodName;
    private double prodPrice;
    private int prodQty;

    public Product(int prodID, String prodName, double prodPrice, int prodQty) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodQty = prodQty;
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

    @Override
    public String toString() {
        return "Product{" + "prodID=" + prodID + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodQty=" + prodQty + '}';
    }

}
