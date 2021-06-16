package com.diego.smarsoft.repositories.interfaces;

import com.diego.smarsoft.models.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryInterface {
    List<Product> getAll();
    Product save(Product product);
    Optional<Product> findById(Long id);
}
