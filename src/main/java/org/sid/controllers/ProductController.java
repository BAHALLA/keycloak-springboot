package org.sid.controllers;

import org.sid.dao.ProductRepository;
import org.sid.entities.Product;
import org.sid.services.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductRepository productRepository;
    private IProductService productService;

    public ProductController(ProductRepository productRepository, IProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }
    @GetMapping("/products")
    public String allProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }
    @GetMapping("/products/analyse")
    public String productPrice(@RequestParam("price") double price, Model model) {
        model.addAttribute("price", price);
        model.addAttribute("products", productRepository.findProductByPriceGreaterThan(price));
        return "products";
    }
    @GetMapping("/products/search")
    public String search(@RequestParam("mc") String mc, Model model) {
        model.addAttribute("price", mc);
        model.addAttribute("products", productRepository.findProductByNameContaining(mc));
        return "products";
    }

    @PostMapping("/products")
    public String save(@RequestBody Product product) {

        productRepository.save(product);
        return "redirect:products";
    }

}
