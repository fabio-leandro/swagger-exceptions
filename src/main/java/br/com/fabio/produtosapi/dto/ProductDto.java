package br.com.fabio.produtosapi.dto;

import java.util.Objects;

public class ProductDto {

    private Long id;
    private String description;
    private Double cost;
    private Double price;

    public ProductDto(){}

    public ProductDto(Long id, String description, Double cost, Double price) {
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(cost, that.cost) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, cost, price);
    }
}

