package com.npci.loanApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npci.loanApplication.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    // You can add custom query methods if needed
}

