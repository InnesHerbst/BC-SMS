package DataLayer;

import java.util.ArrayList;
import BusinessLayer.Order;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marline
 */
public class OrderDataHandler {

    public Order GetOrder(int id) throws ClassNotFoundException, SQLException {
        return null;
    }

    public ArrayList<Order> GetOrder(String... params) throws SQLException, Exception {
        ArrayList<Order> data = new ArrayList<>();

        return data;
    }

    public boolean InsertOrder(Order order) {
        return false;
    }

    public boolean UpdateOrder(Order order) throws SQLException, ClassNotFoundException {
        return false;
    }

    public boolean DeleteOrder(int id) throws SQLException, ClassNotFoundException {
        return false;

    }
}
