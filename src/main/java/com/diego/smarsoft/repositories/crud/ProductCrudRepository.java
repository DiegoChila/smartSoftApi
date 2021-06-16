package com.diego.smarsoft.repositories.crud;

import com.diego.smarsoft.models.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Long> {
}
