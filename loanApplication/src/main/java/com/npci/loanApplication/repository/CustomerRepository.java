package com.npci.loanApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npci.loanApplication.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can add custom query methods if needed
    Customer findByEmail(String email);
    Customer findByEmailAndPassword(String email, String password);
}
