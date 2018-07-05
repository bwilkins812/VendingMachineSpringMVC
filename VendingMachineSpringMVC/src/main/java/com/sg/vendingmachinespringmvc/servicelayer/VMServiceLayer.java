/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.servicelayer;

import com.sg.vendingmachinespringmvc.model.Product;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author brettwilkins
 */
public interface VMServiceLayer {
      
    public List<Product> getProducts();

    public void addMoney(String money);
    
    public String selectItem(String itemNumber);
    
    public String selectItemString();
    
    public void makePurchase();
    
    public BigDecimal getDeposit();

    public void setDeposit(BigDecimal deposit);
    
    public String getMessage();
    
    public void setMessage(String message);
    
    public String getChangeDue();
    
    public void getChange();
    
    

}
