package com.example.inventory_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.inventory_service.model.product;
import com.example.inventory_service.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Inject the URL from application.properties
    @Value("${notification.service.url}")
    private String notificationUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    // Get all products
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    // Create new product
    public product createProduct(product product) {
        product savedProduct = productRepository.save(product);
        checkAndNotify(savedProduct); // Check stock after saving
        return savedProduct;
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

        product updatedProduct = productRepository.save(product);
        checkAndNotify(updatedProduct); // Check stock after updating
        return updatedProduct;
    }

    // Helper method to communicate with Notification Service
    private void checkAndNotify(product product) {
        if (product.getQuantity() < 5) {
            try {
                // Sends the product object to the Notification Service
                restTemplate.postForObject(notificationUrl, product, String.class);
                System.out.println("Low stock alert sent for: " + product.getName());
            } catch (Exception e) {
                // Prevents the Inventory Service from crashing if Notif Service is down
                System.err.println("Failed to send notification: " + e.getMessage());
            }
        }
    }

    // Delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Low stock products (Internal list)
    public List<product> getLowStockProducts() {
        return productRepository.findByQuantityLessThan(10);
    }
}