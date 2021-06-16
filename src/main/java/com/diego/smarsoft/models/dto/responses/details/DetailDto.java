package com.diego.smarsoft.models.dto.responses.details;

import com.diego.smarsoft.models.dto.responses.invoices.InvoiceDto;
import com.diego.smarsoft.models.dto.responses.products.ProductDto;

public class DetailDto {
    private Long id;
    private InvoiceDto invoice;
    private ProductDto product;
    private Integer quantity;
    private Integer price;

    public DetailDto(Long id, InvoiceDto invoice, ProductDto product, Integer quantity, Integer price) {
        this.id = id;
        this.invoice = invoice;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InvoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDto invoice) {
        this.invoice = invoice;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
