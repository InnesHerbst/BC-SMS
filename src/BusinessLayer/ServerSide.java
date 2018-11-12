package BusinessLayer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Marline
 */
public class ServerSide extends Thread implements Runnable {

    public ServerSide() {
        super();
    }

    @Override
    public void run() {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);

            StaffService staffs = new StaffService();
            StockService stocks = new StockService();
            ProductService prods = new ProductService();
            AdminService admins = new AdminService();

            reg.bind("ProductService", prods);
            reg.bind("StockService", stocks);
            reg.bind("StaffService", staffs);
            reg.bind("AdminService", admins);

            //Naming.bind("MyCalc", rem);
            System.out.println("Server is running...");
            while (true) {
                Thread.sleep(100);
            }

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (AlreadyBoundException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
