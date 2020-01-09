package org.sid.services;

import org.sid.entities.Category;
import org.sid.entities.Product;

public class CategoryServiceImpl implements ICategoryService {

    /*
     *@return double
     *average of total price of products in a category
     */
    @Override
    public double avgPriceProductsOfCategory(Category category) {
        double sum = category.getProducts().stream().mapToDouble(Product::getPrice).sum();
        return sum / category.getProducts().size();
    }
}
