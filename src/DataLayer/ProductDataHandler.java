/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import java.util.ArrayList;
import BusinessLayer.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author matt.maree
 */
public class ProductDataHandler {
    public Product GetProduct(int id) throws ClassNotFoundException, SQLException
    {        
        return null;
    }

    public ArrayList<Product> GetProduct(String... params) throws SQLException, Exception
    {
        ArrayList<Product> data = new ArrayList<>();
        
            
        return data;
    }

   public boolean InsertProduct(Product product) {
       return false;
   }

    public boolean UpdateProduct(Product product) throws SQLException, ClassNotFoundException
    {        
        return false;
    }

    public boolean DeleteProduct(int id) throws SQLException, ClassNotFoundException
    {        
        return false;

    }
}
