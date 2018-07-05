/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.servicelayer;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Product;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author brettwilkins
 */
public class VMServiceLayerImpl implements VMServiceLayer {

    private VendingMachineDao dao;
    private BigDecimal deposit = new BigDecimal("0.00");
    private BigDecimal dollars = new BigDecimal("1.00");
    private BigDecimal quarters = new BigDecimal("0.25");
    private BigDecimal dimes = new BigDecimal("0.10");
    private BigDecimal nickels = new BigDecimal("0.05");
    private BigDecimal pennies = new BigDecimal("0.01");
    private BigDecimal depositShort = new BigDecimal("0.0");
    private BigDecimal absoluteShort = new BigDecimal("0.0");
    private int quarterCount = 0;
    private int dimeCount;
    private int nickelCount;
    private int pennyCount;
    private int intItemNumber = 0;
    private String message = "";
    String itemNumberString = "";
    String changeDue = "";

    @Inject
    public VMServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Product> getProducts() {

        List<Product> itemList = dao.getProducts();

        return itemList;

    }

    @Override
    public void addMoney(String money) {
        switch (money) {
            case "addDollar":
                deposit = deposit.add(dollars);
                break;
            case "addQuarter":
                deposit = deposit.add(quarters);
                break;
            case "addDime":
                deposit = deposit.add(dimes);
                break;
            case "addNickel":
                deposit = deposit.add(nickels);
                break;
            case "addPenny":
                deposit = deposit.add(pennies);
                break;
            default:
                deposit = deposit.add(BigDecimal.ZERO);
                break;
        }

    }

    @Override
    public String selectItem(String itemNumber) {

        intItemNumber = Integer.parseInt(itemNumber);
        itemNumberString = Integer.toString(intItemNumber);
        return itemNumberString;
    }

    @Override
    public String selectItemString() {
        return itemNumberString;
    }

    @Override
    public void makePurchase() {

        Product product = dao.getItemNumber(intItemNumber);
        BigDecimal bigDPrice = new BigDecimal(product.getPrice());
        int quantity = product.getQuantity();
        if (quantity <= 0) {
            message = "SOLD OUT!!!";
        } else {
            depositShort = deposit.subtract(bigDPrice);
            if (depositShort.compareTo(BigDecimal.ZERO) < 0) {
                absoluteShort = depositShort.abs();
                message = "Please deposit $" + absoluteShort;
            } else {
                deposit = depositShort;
                quantity = quantity - 1;
                product.setQuantity(quantity);
                getChange();
                message = "Thank You!";
            }

        }

    }

    @Override
    public BigDecimal getDeposit() {
        return deposit;
    }

    @Override
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getChangeDue() {
        return changeDue;
    }

    @Override
    public void getChange() {
        if (itemNumberString == null) {
            message = null;
            changeDue = null;
        } else {
            while (deposit.compareTo(quarters) > 0 || (deposit.compareTo(quarters) == 0)) {
                quarterCount++;
                deposit = deposit.subtract(quarters);

            }

            while (deposit.compareTo(dimes) > 0 || (deposit.compareTo(dimes) == 0)) {
                dimeCount++;
                deposit = deposit.subtract(dimes);

            }
            while (deposit.compareTo(nickels) > 0 || (deposit.compareTo(nickels) == 0)) {
                nickelCount++;
                deposit = deposit.subtract(nickels);

            }
            while (deposit.compareTo(pennies) > 0 || (deposit.compareTo(pennies) == 0)) {
                pennyCount++;
                deposit = deposit.subtract(pennies);

            }

            itemNumberString = null;
            message = null;
            changeDue = (quarterCount + " Quarters, " + dimeCount + " Dimes, " + nickelCount + " Nickels, " + pennyCount + " Pennies.");
            quarterCount = 0;
            dimeCount = 0;
            nickelCount = 0;
            pennyCount = 0;
        }

    }

}
