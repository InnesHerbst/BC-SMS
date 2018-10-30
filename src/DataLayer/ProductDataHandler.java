package DataLayer;

import java.util.ArrayList;
import BusinessLayer.Product;
import BusinessLayer.Stock;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marline
 */
public class ProductDataHandler extends ConnectionHandler {

//    public Product GetProduct(int id) throws ClassNotFoundException, SQLException {
//        return null;
//    }
//
//    public ArrayList<Product> GetProduct(String... params) throws SQLException, Exception {
//        ArrayList<Product> data = new ArrayList<>();
//
//        return data;
//    }
//
//    public boolean InsertProduct(Product product) {
//        return false;
//    }
//
//    public boolean UpdateProduct(Product product) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    public boolean DeleteProduct(int id) throws SQLException, ClassNotFoundException {
//        return false;
//    }
    private static ProductDataHandler productDataHandler;

    public ProductDataHandler() {
        super();
    }

    public static ProductDataHandler getInstance() {
        if (productDataHandler == null) {
            productDataHandler = new ProductDataHandler();
        }

        return productDataHandler;
    }

    //Get All Stock
    public List<Product> fetchProductData() throws SQLException {
        List<Product> product = new ArrayList<>();
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

                    product.add(new Product(sID, sName, sPrice, sQuant));

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
        return product;
    }

    public List<Product> viewProductData(int ID) throws SQLException {
        List<Product> product = new ArrayList<>();
        PreparedStatement sCMD = null;

        try {
            if (ConnectDatabase()) {
                sCMD = getDbConnection().prepareStatement("Execute SP_ViewStock");

                ResultSet result = sCMD.executeQuery();

                while (result.next()) {
                    int sID = result.getInt("Stock_ID");
                    String sName = result.getString("Product_Name");
                    double sPrice = result.getDouble("Product_Price");
                    int sQuant = result.getInt("product_Quantity");

                    product.add(new Product(sID, sName, sPrice, sQuant));
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
        return product;
    }

    public String[] addProduct(String prodName, double prodPrice, int catagoryID) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement iCMD = null;

        try {
            if (ConnectDatabase()) {
                iCMD = getDbConnection().prepareStatement("INSERT INTO Product (Product_Name,Product_Price,Category_ID) VALUES(?,?,?)");
                iCMD.setString(1, prodName);
                iCMD.setDouble(2, prodPrice);
                iCMD.setInt(3, catagoryID);

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

    public String[] updateProduct(int sID, int sQuant) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement uCMD = null;

        try {
            if (ConnectDatabase()) {
                uCMD = getDbConnection().prepareStatement("UPDATE Product SET product_Quantity = ? WHERE Product_ID = ?");
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

    public String[] deleteProduct(int sID) throws SQLException {
        String[] arg = new String[2];
        PreparedStatement dCMD = null;

        try {
            if (ConnectDatabase()) {
                dCMD = getDbConnection().prepareStatement("DELETE FROM Product WHERE Product_ID = ?");
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
