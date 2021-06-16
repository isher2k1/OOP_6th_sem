package com.databases.server.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "public", catalog = "db")
public class Category {
    private Long categoryNumber;
    private String categoryName;

    @Id
    @Column(name = "category_number")
    public Long getCategoryNumber() {
        return categoryNumber;
    }

    public void setCategoryNumber(Long categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    @Basic
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryNumber, category.categoryNumber) && Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryNumber, categoryName);
    }

    //
//    private List<Product> products;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> categories) {
//        this.products = categories;
//    }
}
