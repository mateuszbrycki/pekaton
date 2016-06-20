package com.springiscoming.repository;

import com.springiscoming.model.purchase.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT COUNT(*) FROM Purchase pu WHERE pu.customer.id = :customerId")
    Integer getPurchasesCounter(@Param("customerId") Long customerId);

    @Query("SELECT COALESCE(SUM(pu.value),0) FROM Purchase pu WHERE pu.customer.id = :customerId")
    Float getPurchasesSummaryCost(@Param("customerId") Long customerId);

    @Query("SELECT COUNT(p) as value, p.customer.postCode as postCode FROM Purchase p GROUP BY p.customer.postCode")
    List<Object[]> getPostCodesStatistics();
}
