package com.npci.loanApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.loanApplication.entities.Customer;
import com.npci.loanApplication.entities.Loan;
import com.npci.loanApplication.entities.LoanType;
import com.npci.loanApplication.repository.CustomerRepository;
import com.npci.loanApplication.repository.LoanRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanRepository loanRepository;

    public Customer registerCustomer(String firstName, String lastName, String email, String password, String pan, String phone) {
        // Implement registration logic and save the customer
        Customer customer = new Customer(firstName, lastName, email, password, pan, phone);
        return customerRepository.save(customer);
    }

    public Customer loginCustomer(String email, String password) {
        // Implement login logic and return the customer if login is successful
        return customerRepository.findByEmailAndPassword(email, password);
    }

    public List<Loan> getAvailableLoans(Long customerId) {
        // Implement logic to retrieve available loans for the customer
        // You might want to filter loans based on certain criteria
        return loanRepository.findAll();
    }

    public Loan applyForLoan(Long customerId, LoanType loanType) {
        // Implement logic to apply for a loan and save it in the database
        // You may want to associate the loan with the customer
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            Loan loan = new Loan();
            return loanRepository.save(loan);
        } else {
            // Handle the case where the customer is not found
            return null;
        }
    }
}

