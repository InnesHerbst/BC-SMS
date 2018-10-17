/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import BusinessLayer.Stock;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author matt.maree
 */
public class StockDataHandler {
    public Stock GetStock(int id) throws ClassNotFoundException, SQLException
    {        
        return null;
    }

    public ArrayList<Stock> GetStock(String... params) throws SQLException, Exception
    {
        ArrayList<Stock> data = new ArrayList<>();
        
            
        return data;
    }

   public boolean InsertStock(Stock stock) {
       return false;
   }

    public boolean UpdateStock(Stock nStock) throws SQLException, ClassNotFoundException
    {        
        return false;
    }

    public boolean DeleteStock(int id) throws SQLException, ClassNotFoundException
    {        
        return false;

    }
}
