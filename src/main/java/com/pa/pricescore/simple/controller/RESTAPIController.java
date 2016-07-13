package com.pa.pricescore.simple.controller;

import com.pa.pricescore.simple.api.MessageRequest;
import com.pa.pricescore.simple.entity.Purchase;
import com.pa.pricescore.simple.impl.IDGen;
import com.pa.pricescore.simple.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by Jek on 24.06.16.
 */
@RestController
public class RESTAPIController
{
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private IDGen idGen;

    @RequestMapping(value = "/price", method = RequestMethod.POST)
    public String inputPrice(@RequestBody(required = true) MessageRequest request)
    {

        Purchase purchase = new Purchase();
        purchase.setId(idGen.getId());
        purchase.setShop(request.getShop());
        purchase.setItem(request.getItem());
        purchase.setPrice(request.getPrice());
        purchase.setUserId(request.getUserId());
        purchase.setDate(new Date(System.currentTimeMillis()));
        purchaseRepository.save(purchase);
        return request.getUserId().toString() + request.getShop() + request.getItem()+ request.getPrice().toString();
    }
    @RequestMapping(value = "/quote/{userid}", method = RequestMethod.GET)
    public Collection<Purchase> getPurchase(@PathVariable(value = "userid") Integer userid)
    {

        return purchaseRepository.findPurchaceByUserId(userid);
    }

}
