package com.example.inventory_service.controller;

import com.example.inventory_service.model.product;
import com.example.inventory_service.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final ProductService productService;

    public WebController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String viewProducts(Model model) {
        // This ensures the list is sent to index.html
        model.addAttribute("products", productService.getAllProducts());
        // This makes sure the form has a 'product' object to bind to
        model.addAttribute("product", new product()); 
        return "index";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute("product") product product) {
        try {
            productService.createProduct(product); 
            return "redirect:/"; 
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/?error";
        }
    }
}