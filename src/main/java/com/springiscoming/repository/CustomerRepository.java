package com.springiscoming.repository;

import com.springiscoming.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findOneByCustomerId(Long customerId);
}
