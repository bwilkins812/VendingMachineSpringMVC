/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.contoller;

import com.sg.vendingmachinespringmvc.model.Product;
import com.sg.vendingmachinespringmvc.servicelayer.VMServiceLayer;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author brettwilkins
 */
@Controller
public class VMController {

    private VMServiceLayer service;

    @Inject
    public VMController(VMServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayVendingMachine(Model model) {

        List<Product> itemList = service.getProducts();

        model.addAttribute("itemList", itemList);
        model.addAttribute("deposit", service.getDeposit());
        model.addAttribute("messages", service.getMessage());
        model.addAttribute("itemNumber", service.selectItemString());
        model.addAttribute("change", service.getChangeDue());

        return "vendingMachine";
    }

    @RequestMapping(value = "/depositMoney/{money}", method = RequestMethod.GET)
    public String addMoney(@PathVariable String money) {

        service.addMoney(money);

        return "redirect:/";
    }

    @RequestMapping(value = "/itemSelection/{itemNumber}", method = RequestMethod.GET)
    public String itemSelection(@PathVariable String itemNumber) {

        service.selectItem(itemNumber);

        return "redirect:/";
    }

    @RequestMapping(value = "/makePurchase", method = RequestMethod.GET)
    public String makePurchase() {
        
        service.makePurchase();
        
        return "redirect:/";
    }

    @RequestMapping(value = "/returnChange", method = RequestMethod.GET)
    public String returnChange() {
        
        service.getChange();

        return "redirect:/";

    }

}
