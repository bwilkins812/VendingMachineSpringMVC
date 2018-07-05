/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Product;
import java.util.List;

/**
 *
 * @author brettwilkins
 */
public interface VendingMachineDao {
    
   public List<Product> getProducts();
   
   public Product getItemNumber(int itemNumber);

}
