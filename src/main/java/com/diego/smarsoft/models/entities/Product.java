package com.diego.smarsoft.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Column(name = "id_product")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede ser vacío")
    @Size(min = 4, max = 50, message = "El nombre debe tener entre 4 y 50 caracteres")
    private String name;

    @NotNull(message = "Debe especificar el precio")
    private Integer price;

    @NotNull(message = "Debe especificar la cantidad de productos disponible")
    private Integer stock;

    @OneToMany(mappedBy = "product")
    private List<Detail> details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
