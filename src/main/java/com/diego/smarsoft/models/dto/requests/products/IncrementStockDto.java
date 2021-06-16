package com.diego.smarsoft.models.dto.requests.products;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class IncrementStockDto {
    @NotNull(message = "Debe especificar el producto")
    private Long id;

    @NotNull(message = "Debe especificar el número de incremento")
    @Min(value = 1, message = "El número a incrementar debe ser mayor a 0")
    private int increment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }
}
