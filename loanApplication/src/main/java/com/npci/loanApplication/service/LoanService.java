package com.npci.loanApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.loanApplication.entities.Loan;
import com.npci.loanApplication.repository.LoanRepository;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        // Implement logic to retrieve all loans
        return loanRepository.findAll();
    }

    // Add additional methods as needed based on your requirements
}
