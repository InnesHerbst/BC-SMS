/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.util.Comparator;

/**
 *
 * @author Innes Herbst
 */
public class StockQuantComparator implements Comparator<Stock>{

    @Override
    public int compare(Stock o1, Stock o2) {
        return o1.getQuantity() - o2.getQuantity();
    }
    
}
