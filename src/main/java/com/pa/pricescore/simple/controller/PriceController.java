package com.pa.pricescore.simple.controller;

import com.pa.pricescore.simple.api.MessageRequest;
import com.pa.pricescore.simple.entity.Purchase;
import com.pa.pricescore.simple.impl.IDGen;
import com.pa.pricescore.simple.impl.PriceImpl;
import com.pa.pricescore.simple.repository.PurchaseRepository;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Jek on 24.06.16.
 */
@RestController
@RequestMapping("/api/v1/price-core")
public class PriceController
{

    @Autowired
    private PriceImpl price;


    @RequestMapping(value = "/price", method = RequestMethod.POST)
    public String inputPrice(@RequestBody(required = true) MessageRequest request)
    {
        return price.addItem(request);
    }

    @RequestMapping(value = "/price", method = RequestMethod.GET)
    public Iterable<Purchase> getPurchase()
    {
        return price.getAllPrice();
    }

    @RequestMapping(value = "/quote/{userid}", method = RequestMethod.GET)
    public List<Purchase> getPurchase(@PathVariable(value = "userid") Integer userid)
    {

        return price.getPricesByUserId(userid);
    }
    @RequestMapping(value = "/shop/{shopName}", method = RequestMethod.GET)
    public List<Purchase> getPurchase(@PathVariable(value = "userid") String shopName)
    {

        return price.getShopByName(shopName);
    }

}
