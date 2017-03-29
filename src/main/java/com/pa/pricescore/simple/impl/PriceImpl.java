package com.pa.pricescore.simple.impl;

import com.pa.pricescore.simple.api.MessageRequest;
import com.pa.pricescore.simple.entity.Purchase;
import com.pa.pricescore.simple.repository.PurchaseRepository;
import com.pa.pricescore.simple.service.DialogConstant;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Jek on 30/03/2017.
 */
@Component
public class PriceImpl
{
    @Autowired
    private PurchaseRepository repository;

    public String addItem(MessageRequest request)
    {
        Purchase purchase = new Purchase(request.getUserId(),
                request.getShop(),
                request.getItem(),
                request.getPrice(),
                new Date(System.currentTimeMillis()));
//        purchase.setId(idGen.getIdString());
//        purchase.setShop();
//        purchase.setItem();
//        purchase.setPrice();
//        purchase.setUserId();
//        purchase.setDate();
        repository.save(purchase);
        return DialogConstant.THANKYOU_DONE + request.getUserId();
    }

    public Iterable<Purchase> getAllPrice()
    {
        return repository.findAll();
    }

    public List<Purchase> getPricesByUserId(Integer userid) {
        return null;//repository.findByUserId(userid);
    }

    public List<Purchase> getShopByName(String shopName) {
        return null;//repository.findByShop(shopName);
    }
}
