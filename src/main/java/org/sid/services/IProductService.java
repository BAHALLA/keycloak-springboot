package org.sid.services;

import org.sid.entities.Category;
import org.sid.entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> findProductsPriceHigherThan(double price);
}
