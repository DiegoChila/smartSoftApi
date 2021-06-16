package com.diego.smarsoft.services;

import com.diego.smarsoft.models.dto.requests.products.IncrementStockDto;
import com.diego.smarsoft.models.dto.responses.products.NewProductDto;
import com.diego.smarsoft.models.dto.responses.products.ProductDto;
import com.diego.smarsoft.models.entities.Product;
import com.diego.smarsoft.repositories.classes.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAll() {
        List<Product> products = productRepository.getAll();
        List<ProductDto> productsDto = new ArrayList<>();
        for (Product product: products) {
            productsDto.add(new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getStock()));
        }
        return productsDto;
    }

    public NewProductDto save(Product product) {
        Product newProduct = productRepository.save(product);
        return new NewProductDto(true, new ProductDto(newProduct.getId(), newProduct.getName(), newProduct.getPrice(), newProduct.getStock()), null);
    }

    public NewProductDto incrementStock(IncrementStockDto incrementStockDto) {
        Product product = productRepository.findById(incrementStockDto.getId()).orElse(null);
        if (product == null) {
            List<String> errors = new ArrayList<>();
            errors.add("Producto no encontrado");
            return new NewProductDto(false, null, errors);
        }
        product.setStock(product.getStock() + incrementStockDto.getIncrement());
        productRepository.save(product);
        return new NewProductDto(true, new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getStock()), null);
    }
}
