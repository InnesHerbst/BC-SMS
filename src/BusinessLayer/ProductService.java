package BusinessLayer;

import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author Marline
 */
public class ProductService implements IProduct, Serializable{

    public Product UpdateView(int id) {
        return Product.UpdateView(id).get(0);
    }

    public void AddProduct(String prodName, double prodPrice, int catID) {
        Product.AddProduct(prodName, prodPrice, catID);
    }

    public void UpdateProduct(int id, int quantity, String name) {
        Product.UpdateProduct(id, quantity, name);
    }

    public void DeleteProduct(int id, String name) {
        Product.DeleteProduct(id, name);
    }
    
}