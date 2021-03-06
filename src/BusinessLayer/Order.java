package BusinessLayer;

import java.util.Date;
import DataLayer.OrderDataHandler;
import DataLayer.StockDataHandler;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marline
 */
public class Order implements Serializable {

    private int orderID;
    private String orderDesc;
    private Date orderDate;
    private int orderQty;
    private Date pickUpDate;
    public OrderDataHandler dbConn;

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
}
