package com.pa.pricescore.simple.entity;


import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Jek on 03.07.16.
 */

@Document(indexName = "purchase", type = "purchase", shards = 1, replicas = 0, refreshInterval = "-1")
public class Purchase
{
    private String id;
    private Integer userId;
    private String shop;
    private String item;
    private BigDecimal price;
    private Date date;

    public Purchase() {
    }

    public Purchase(Integer userId, String shop, String item, BigDecimal price, Date date)
    {
        this.userId = userId;
        this.shop = shop;
        this.item = item;
        this.price = price;
        this.date = date;
    }



    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {

        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getShop() {
        return shop;
    }

    public String getItem() {
        return item;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
}
