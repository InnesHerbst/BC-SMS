package DataLayer;

import java.util.ArrayList;
import BusinessLayer.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marline
 */
public class ProductDataHandler {

    public Product GetProduct(int id) throws ClassNotFoundException, SQLException {
        return null;
    }

    public ArrayList<Product> GetProduct(String... params) throws SQLException, Exception {
        ArrayList<Product> data = new ArrayList<>();

        return data;
    }

    public boolean InsertProduct(Product product) {
        return false;
    }

    public boolean UpdateProduct(Product product) throws SQLException, ClassNotFoundException {
        return false;
    }

    public boolean DeleteProduct(int id) throws SQLException, ClassNotFoundException {
        return false;

    }
}
