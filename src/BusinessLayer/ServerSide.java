package BusinessLayer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Marline
 */
public class ServerSide extends Thread implements Runnable {

    public ServerSide() {
    }

    @Override
    public void run() {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);

            StaffService staffs = new StaffService();
            StockService stocks = new StockService();
            ProductService prods = new ProductService();
            AdminService admins = new AdminService();

            reg.bind("Product", prods);
            reg.bind("Stock", stocks);
            reg.bind("StaffService", staffs);
            reg.bind("AdminService", admins);

            //Naming.bind("MyCalc", rem);
            System.out.println("Server is running");

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (AlreadyBoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
