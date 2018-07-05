/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author brettwilkins
 */
public class VendingMachineDaoImpl implements VendingMachineDao {

    HashMap<Integer, Product> products = new HashMap<>();

    public VendingMachineDaoImpl() {

        products.put(1, new Product("1", "Snickers", "1.85", 9));
        products.put(2, new Product("2", "M & Ms", "1.50", 2));
        products.put(3, new Product("3", "Pringles", "2.10", 5));
        products.put(4, new Product("4", "Reese's", "1.85", 4));
        products.put(5, new Product("5", "Pretzels", "1.25", 9));
        products.put(6, new Product("6", "Twinkies", "1.95", 3));
        products.put(7, new Product("7", "Doritos", "1.75", 11));
        products.put(8, new Product("8", "Almond Joy", "1.85", 0));
        products.put(9, new Product("9", "Trident", "1.95", 6));

    }

    @Override
    public List<Product> getProducts() {

        return new ArrayList<>(products.values());

    }

    @Override
    public Product getItemNumber(int itemNumber) {

        return products.get(itemNumber);
    }

}
