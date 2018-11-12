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
    public List<Stock> getAuthOrder(int id) {
        return null;
    }

    @Override
    public List<Stock> getUnAuthOrder(int id) {
        return null;
    }

    @Override
    public boolean updateOrder() {
        return false;
    }

}
