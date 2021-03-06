package com.pa.pricescore.simple.repository;

import com.pa.pricescore.simple.entity.Purchase;

import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by Jek on 01.07.16.
 */
@Repository
public interface PurchaseRepository extends MongoRepository<Purchase, UUID>
{
    Collection<Purchase> findPurchaceByUserId(Integer userId);
}
