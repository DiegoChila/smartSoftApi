package com.diego.smarsoft.controllers;

import com.diego.smarsoft.models.dto.requests.products.IncrementStockDto;
import com.diego.smarsoft.models.dto.responses.products.NewProductDto;
import com.diego.smarsoft.models.dto.responses.products.ProductDto;
import com.diego.smarsoft.models.entities.Product;
import com.diego.smarsoft.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public NewProductDto save(@RequestBody @Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> objectsErrors = result.getAllErrors();
            List<String> errors = new ArrayList<String>();
            for (ObjectError error: objectsErrors) {
                errors.add(error.getDefaultMessage());
            }
            return new NewProductDto(false, null, errors);
        }
        return productService.save(product);
    }

    @PutMapping("/incrementStock")
    public NewProductDto incrementStock(@RequestBody @Valid IncrementStockDto incrementStockDto, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> objectsErrors = result.getAllErrors();
            List<String> errors = new ArrayList<String>();
            for (ObjectError error: objectsErrors) {
                errors.add(error.getDefaultMessage());
            }
            return new NewProductDto(false, null, errors);
        }
        return productService.incrementStock(incrementStockDto);
    }
}
