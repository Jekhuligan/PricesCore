package com.pa.pricescore.simple.repository;

import com.pa.pricescore.simple.entity.Purchase;

import com.sun.tools.javac.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Created by Jek on 01.07.16.
 */
public interface PurchaseRepository  extends ElasticsearchRepository<Purchase, String> //extends MongoRepository<Purchase, UUID>
{
    //public List<Purchase> findByUserId(Integer userId);
    //public List<Purchase> findByShop(String shop);
}
