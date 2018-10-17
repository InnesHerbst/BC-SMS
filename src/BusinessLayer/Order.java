package BusinessLayer;

import java.util.Date;
import DataLayer.OrderDataHandler;
import java.sql.SQLException;

/**
 *
 * @author Marline
 */
public class Order {

    private int orderID;
    private String orderDesc;
    private Date orderDate;
    private int orderQty;
    private Date pickUpDate;
    private OrderDataHandler dbConn;

    public Order(int orderID, String orderDesc, Date orderDate, int orderQty, Date pickUpDate) {
        this.orderID = orderID;
        this.orderDesc = orderDesc;
        this.orderDate = orderDate;
        this.orderQty = orderQty;
        this.pickUpDate = pickUpDate;
        this.dbConn = new OrderDataHandler();
    }

    public int getOrderID() {
        return orderID;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Order getOrder(int id) throws ClassNotFoundException, SQLException {
        Order stock = dbConn.GetOrder(getOrderID());
        return stock;
    }

    public boolean addOrder() throws SQLException, ClassNotFoundException {
        return dbConn.InsertOrder(this);
    }

    public boolean updateOrder() throws SQLException, ClassNotFoundException {
        return dbConn.UpdateOrder(this);
    }

    public boolean removeOrder() throws SQLException, ClassNotFoundException {
        return dbConn.DeleteOrder(getOrderID());
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderDesc=" + orderDesc + ", orderDate=" + orderDate + ", orderQty=" + orderQty + ", pickUpDate=" + pickUpDate + ", dbConn=" + dbConn + '}';
    }

}
