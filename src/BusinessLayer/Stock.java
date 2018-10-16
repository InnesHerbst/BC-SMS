/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataLayer.AdminDataHandler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adria
 */
public class Stock {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String category;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Stock(int id, String name, double price, int quantity, String category, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
    }

    
    
    
    public List<Stock> DisplayStock(){
        //AdminDataHandler ad = new AdminDataHandler();
        List<Stock> lst = new ArrayList<>();
        //lst = ad.View_all();
        lst.add(new Stock(1,"Dimond", 20.52, 7, "Jewl", "Shiny"));
        lst.add(new Stock(2,"Gold", 38.52, 2, "Jewl", "Yellow"));
        return lst;
    }
    
    public List<Stock> UpdateView(int id){
        //AdminDataHandler ad = new AdminDataHandler();
        List<Stock> lst = new ArrayList<>();
        //lst = ad.update_view(id);
        lst.add(new Stock(2,"Gold", 38.52, 2, "Jewl", "Yellow"));
        return lst;
    }
    
    public void UpdateStock(List<Stock> stock){
        //AdminDataHandler ad = new AdminDataHandler();
        //ad.updatestock(stock);
    }
    
}
