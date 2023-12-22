package com.npci.loanApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.loanApplication.entities.Customer;
import com.npci.loanApplication.entities.CustomerLoginRequest;
import com.npci.loanApplication.entities.CustomerRegistrationRequest;
import com.npci.loanApplication.entities.Loan;
import com.npci.loanApplication.entities.LoanType;
import com.npci.loanApplication.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody CustomerRegistrationRequest registrationRequest) {
        return customerService.registerCustomer(registrationRequest.getFirstName(), registrationRequest.getLastName(),
                registrationRequest.getEmail(), registrationRequest.getPassword(), registrationRequest.getPan(),
                registrationRequest.getPhone());
    }

    @PostMapping("/login")
    public Customer loginCustomer(@RequestBody CustomerLoginRequest loginRequest) {
        return customerService.loginCustomer(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @GetMapping("/{customerId}/loans")
    public List<Loan> getAvailableLoans(@PathVariable Long customerId) {
        return customerService.getAvailableLoans(customerId);
    }

    @PostMapping("/{customerId}/apply-loan")
    public ResponseEntity<Loan> applyForLoan(@PathVariable Long customerId, @RequestBody LoanType loanType) {
        Loan loan = customerService.applyForLoan(customerId, loanType);
        if (loan != null) {
            return new ResponseEntity<>(loan, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
