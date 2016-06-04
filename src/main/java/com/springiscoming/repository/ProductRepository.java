package com.springiscoming.repository;

import com.springiscoming.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by winio_000 on 2016-06-04.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
