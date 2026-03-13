package com.example.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.inventory_service.model.product;

public interface ProductRepository extends JpaRepository<product, Long> {

    List<product> findByQuantityLessThan(int quantity);

}