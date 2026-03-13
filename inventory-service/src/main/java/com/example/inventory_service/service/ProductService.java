package com.example.inventory_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory_service.model.product;
import com.example.inventory_service.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    // Create new product
    public product createProduct(product product) {
        return productRepository.save(product);
    }

    // Get product by ID
    public Optional<product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Update product
    public product updateProduct(Long id, product productDetails) {

        product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDetails.getName());
        product.setQuantity(productDetails.getQuantity());
        product.setLocation(productDetails.getLocation());

        return productRepository.save(product);
    }

    // Delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Low stock products
    public List<product> getLowStockProducts() {
        return productRepository.findByQuantityLessThan(10);
    }
}