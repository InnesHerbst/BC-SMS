/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import BusinessLayer.Stock;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Innes Herbst
 */
public class StockDataHandler extends ConnectionHandler {

    private static StockDataHandler stockDataHandler;

    private StockDataHandler() {
        super();
    }

    public static StockDataHandler getInstance() {
        if (stockDataHandler == null) {
            stockDataHandler = new StockDataHandler();
        }

        return stockDataHandler;
    }

    //Get All Stock
    public List<Stock> fetchStockData() throws SQLException {
        List<Stock> stock = new ArrayList<>();
        PreparedStatement sCMD = null;

        try {
            if (ConnectDatabase()) {
                sCMD = getDbConnection().prepareStatement("SELECT s.Stock_ID,p.Product_Name,p.Product_Price,s.product_Quantity,c.Category_Name,c.Category_Desc "
                        + "FROM Stock s "
                        + "INNER JOIN "
                        + "ON (s.product_ID = p.Product_ID) "
                        + "INNER JOIN "
                        + "ON (p.Category_ID = c.Category_ID);");

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

        return stock;
    }

    public String[] addStock(int prodID, int ProdQuant, int deptID, int campID) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement iCMD = null;

        try {
            if (ConnectDatabase()) {
                iCMD = getDbConnection().prepareStatement("INSERT INTO Stock (product_ID,product_Quantity,department_ID,campus_ID ) VALUES(?,?,?,?)");
                iCMD.setInt(1, prodID);
                iCMD.setInt(2, ProdQuant);
                iCMD.setInt(3, deptID);
                iCMD.setInt(4, campID);

                int count = iCMD.executeUpdate();

                if (count < 1) {
                    arg[0] = "Error - SQL";
                    arg[1] = "Insert Statement Incorrect";
                } else {
                    arg[0] = "Success";
                    arg[1] = "Insert Statement Correct";
                }
            } else {
                arg[0] = "Error - Database";
                arg[1] = "Database Could not Connect";
            }
        } catch (SQLException e) {
            arg[0] = "Error - SQL";
            arg[1] = e.getMessage();
        } finally {
            if (iCMD != null) {
                iCMD.close();
            }
            DisconnectDatabase();
        }

        return arg;
    }

    public String[] updateStock(int sID, int sQuant) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement uCMD = null;

        try {
            if (ConnectDatabase()) {
                uCMD = getDbConnection().prepareStatement("UPDATE Stock SET product_Quantity = ? WHERE Stock_ID = ?");
                uCMD.setInt(1, sQuant);
                uCMD.setInt(2, sID);

                int count = uCMD.executeUpdate();

                if (count < 1) {
                    arg[0] = "Error - SQL";
                    arg[1] = "Update Statement Incorrect";
                } else {
                    arg[0] = "Success";
                    arg[1] = "Update Statement Correct";
                }
            } else {
                arg[0] = "Error - Database";
                arg[1] = "Databse Could Not Connect";
            }

        } catch (SQLException e) {
            arg[0] = "Error - SQL";
            arg[1] = e.getMessage();
        } finally {
            if (uCMD != null) {
                uCMD.close();
            }

            DisconnectDatabase();
        }

        return arg;
    }

    public String[] deleteStock(int sID) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement dCMD = null;

        try {
            if (ConnectDatabase()) {
                dCMD = getDbConnection().prepareStatement("DELETE FROM Stock WHERE Stock_id = ?");
                dCMD.setInt(1, sID);

                int count = dCMD.executeUpdate();

                if (count < 1) {
                    arg[0] = "Error - SQL";
                    arg[1] = "Delete Statement Incorrect";
                } else {
                    arg[0] = "Success";
                    arg[1] = "Delete Statement Correct";
                }
            } else {
                arg[0] = "Error - Database";
                arg[1] = "Databse Could Not Connect";
            }

        } catch (SQLException e) {
            arg[0] = "Error - SQL";
            arg[1] = e.getMessage();
        } finally {
            if (dCMD != null) {
                dCMD.close();
            }

            DisconnectDatabase();
        }

        return arg;
    }

}
