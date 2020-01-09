package org.sid.services;

import org.sid.dao.ProductRepository;
import org.sid.entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findProductsPriceHigherThan(double price) {
        List<Product> products = new ArrayList<>();

        productRepository.findAll().forEach( p -> {
            if (p.getPrice() > price)
                products.add(p);
        });
        return products;
    }
}
