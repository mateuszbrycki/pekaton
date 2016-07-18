package com.springiscoming.repository;

import com.springiscoming.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.purchase.purchaseId = :purchaseId")
    List<Product> getProductListsByPurchaseId(@Param("purchaseId") Long purchaseId);

    Product findFirstByCodeOrderByProductId(String code);
}
