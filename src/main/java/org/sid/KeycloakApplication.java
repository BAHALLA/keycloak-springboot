package org.sid;

import org.sid.dao.CategoryRepository;
import org.sid.dao.CustomerRepository;
import org.sid.dao.ProductRepository;
import org.sid.entities.Category;
import org.sid.entities.Customer;
import org.sid.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class KeycloakApplication {

    private Random random = new Random();
    public static void main(String[] args) {
        SpringApplication.run(KeycloakApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(CustomerRepository customerRepository,
                                   ProductRepository productRepository,
                                   CategoryRepository categoryRepository) {
        return  args -> {
            customerRepository.save(new Customer(null, "Taoufiq","BAHALLA"));
            customerRepository.save(new Customer(null, "Mohamed","BAHALLA"));
            customerRepository.save(new Customer(null, "Azdine","BAHALLA"));

            categoryRepository.save(new Category(null, "Computers", new ArrayList<>()));
            categoryRepository.save(new Category(null, "TVs", new ArrayList<>()));
            categoryRepository.save(new Category(null, "Phones", new ArrayList<>()));


            categoryRepository.findAll().forEach(System.out::println);

            categoryRepository.findAll().forEach(c -> {
                if(c.getName().contains("Comp")) {
                    Stream.of("DELL XPS", "HP 2018", "Lenovo 2015", "Mac Book Pro").forEach( n -> {
                        Product p = new Product(null, n, random.nextDouble()*100 +10, c );
                        productRepository.save(p);
                        c.getProducts().add(p);
                        categoryRepository.save(c);
                    });
                } else if(c.getName().contains("Phon")) {
                    Stream.of("Samsung Galaxy j1", "IPhone 8", "OPPO").forEach(n -> {
                        Product p = new Product(null, n, random.nextDouble()*100 +10, c );
                        productRepository.save(p);
                        c.getProducts().add(p);
                        categoryRepository.save(c);
                    });
                } else {
                    Stream.of("LG TV", "Sumsung TV", "Sony TV").forEach(n -> {
                        Product p = new Product(null, n, random.nextDouble()*100 +10, c );
                        productRepository.save(p);
                        c.getProducts().add(p);
                        categoryRepository.save(c);
                    });
                }
            });
        };
    }
}
