package org.sid.controllers;

import org.sid.dao.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public String customers(Principal principal, Model model) {

        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("username", principal.getName());
        return "customers";
    }
}
