package com.diego.smarsoft.repositories.classes;

import com.diego.smarsoft.models.entities.Product;
import com.diego.smarsoft.repositories.crud.ProductCrudRepository;
import com.diego.smarsoft.repositories.interfaces.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductRepositoryInterface {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Override
    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productCrudRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productCrudRepository.findById(id);
    }
}
