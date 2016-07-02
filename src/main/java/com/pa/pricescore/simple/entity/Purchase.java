package com.pa.pricescore.simple.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Jek on 03.07.16.
 */
@Document(collection = "purchase")
public class Purchase
{
    private UUID id;
    private Integer userId;
    private String shop;
    private String item;
    private BigDecimal price;
    private Date date;

    public void setId(UUID id) {
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

    public UUID getId() {

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
