/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataLayer.OrderDataHandler;
import java.rmi.Remote;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marline
 */
public interface IOrder extends Remote {

    List<Stock> getAuthOrder(int id);

    List<Stock> getUnAuthOrder(int id);

    boolean updateOrder();

}
