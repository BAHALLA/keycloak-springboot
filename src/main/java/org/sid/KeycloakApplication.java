package org.sid;

import org.sid.dao.CustomerRepository;
import org.sid.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeycloakApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeycloakApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(CustomerRepository customerRepository) {
        return  args -> {
            customerRepository.save(new Customer(null, "Taoufiq","BAHALLA"));
            customerRepository.save(new Customer(null, "Mohamed","BAHALLA"));
            customerRepository.save(new Customer(null, "Azdine","BAHALLA"));
        };
    }
}
