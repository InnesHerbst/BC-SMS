package DataLayer;

import java.util.ArrayList;
import BusinessLayer.Order;
import BusinessLayer.Stock;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marline
 */
public class OrderDataHandler extends ConnectionHandler {

    private static OrderDataHandler orderDataHandler;

    public OrderDataHandler() {
        super();
    }

    public static OrderDataHandler getInstance() {
        if (orderDataHandler == null) {
            orderDataHandler = new OrderDataHandler();
        }

        return orderDataHandler;
    }

    public List<Stock> GetAuthOrders() throws ClassNotFoundException, SQLException {
        List<Stock> stock = new ArrayList<>();
        PreparedStatement sCMD = null;

        try {
            if (ConnectDatabase()) {
                sCMD = getDbConnection().prepareStatement("Execute SP_FetchStock");

                ResultSet result = sCMD.executeQuery();

                while (result.next()) {
                    int sID = result.getInt("Stock_ID");
                    String sName = result.getString("Product_Name");
                    double sPrice = result.getDouble("Product_Price");
                    int sQuant = result.getInt("product_Quantity");
                    String sCat = result.getString("Category_Name");
                    String sCDesc = result.getString("Category_Desc");

                    stock.add(new Stock(sID, sName, sPrice, sQuant, sCat, sCDesc));
                }

            }
        } catch (SQLException e) {
            System.out.println("Problem Occured : " + e.getMessage());
        } finally {
            if (sCMD != null) {
                sCMD.close();
            }

            DisconnectDatabase();
        }
        //stock.add(new Stock(2, "Piet", 18, 5, "new", "new"));
        return stock;
    }
    
    public List<Stock> GetUnAuthOrders() throws ClassNotFoundException, SQLException {
        List<Stock> stock = new ArrayList<>();
        PreparedStatement sCMD = null;

        try {
            if (ConnectDatabase()) {
                sCMD = getDbConnection().prepareStatement("Execute SP_FetchUnAutStock");

                ResultSet result = sCMD.executeQuery();

                while (result.next()) {
                    int sID = result.getInt("Stock_ID");
                    String sName = result.getString("Product_Name");
                    double sPrice = result.getDouble("Product_Price");
                    int sQuant = result.getInt("product_Quantity");
                    String sCat = result.getString("Category_Name");
                    String sCDesc = result.getString("Category_Desc");

                    stock.add(new Stock(sID, sName, sPrice, sQuant, sCat, sCDesc));
                }

            }
        } catch (SQLException e) {
            System.out.println("Problem Occured : " + e.getMessage());
        } finally {
            if (sCMD != null) {
                sCMD.close();
            }

            DisconnectDatabase();
        }
        //stock.add(new Stock(2, "Piet", 18, 5, "new", "new"));
        return stock;
    }

    public boolean UpdateOrder(int stockID) throws SQLException, ClassNotFoundException {
        PreparedStatement uCMD = null;
        
        try {
            ConnectDatabase();
            
            uCMD = getDbConnection().prepareStatement("Update Stock set stock_confirmation = 'Yes' where Stock_ID= '?'");
            uCMD.setInt(0, stockID);
            
            int count = uCMD.executeUpdate();
            
            if(count != 1){
                return false;
            }
            
        } catch (Exception e) {
        }finally{
            try{
                if(uCMD != null){
                    uCMD.close();
                }
            }catch (SQLException sqle){
                
            }
            
            DisconnectDatabase();
        }
        
        return true;
    }
}
