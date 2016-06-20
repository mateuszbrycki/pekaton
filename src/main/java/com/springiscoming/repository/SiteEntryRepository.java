package com.springiscoming.repository;

import com.springiscoming.model.siteEntry.SiteEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SiteEntryRepository extends JpaRepository<SiteEntry, String> {

    @Query("SELECT COALESCE(AVG(se.visitTime), 0) FROM SiteEntry se WHERE se.customer.id = :customerId")
    Float getCustomerAverageVisitTime(@Param("customerId") Long customerId);

    @Query("SELECT COUNT(*) FROM SiteEntry se WHERE se.customer.id = :customerId")
    Integer getCustomerVisitsCounter(@Param("customerId") Long customerId);

    @Query("SELECT COUNT(*) FROM SiteEntry se WHERE se.customer.id = :customerId AND se.isDirectEntry = true")
    Integer getCustomerDirectVisitsCounter(@Param("customerId") Long customerId);

}
