package com.diego.smarsoft.models.dto.responses.products;

import java.util.List;

public class NewProductDto {
    private boolean success;
    private ProductDto product;
    private List<String> errors;

    public NewProductDto(boolean success, ProductDto product, List<String> errors) {
        this.success = success;
        this.product = product;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
