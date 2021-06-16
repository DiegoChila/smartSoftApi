package com.diego.smarsoft.models.dto.requests.details;

import javax.validation.constraints.NotNull;

public class NewDetailItemDto {
    private Long idProduct;

    private Integer quantity;

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
