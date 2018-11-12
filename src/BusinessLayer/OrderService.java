package BusinessLayer;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Marline
 */
public class OrderService extends UnicastRemoteObject implements Serializable, IOrder {

    public OrderService() throws RemoteException {
        super();
    }

    @Override
    public List<Stock> GetAuthOrder() {
        return Stock.GetAuthOrder();
    }

    @Override
    public List<Stock> GetUnAuthStock() {
        return Stock.GetUnAuthStock();
    }

    @Override
    public boolean UpdateStock(int stockID) {
        return Stock.UpdateStock(stockID);
    }

}
