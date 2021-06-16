package com.databases.server.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "public", catalog = "db")
public class Product {
    private Integer idProduct;
    private String productName;
    private String characteristics;
    private Long category;

    @Id
    @Column(name = "id_product")
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "characteristics")
    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(idProduct, product.idProduct) && Objects.equals(productName, product.productName) && Objects.equals(characteristics, product.characteristics) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, productName, characteristics, category);
    }

    @Basic
    @Column(name = "category_number")
    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}
