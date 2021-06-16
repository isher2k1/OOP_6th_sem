package com.databases.server.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "store_product", schema = "public", catalog = "db")
public class StoreProduct {
  private String upc;
  private Long sellingPrice;
  private Long productsNumber;
  private Boolean promotionalProduct;
  private Long product;
  private Long storeProductChild;

  @Id
  @Column(name = "upc")
  public String getUpc() {
    return upc;
  }

  public void setUpc(String upc) {
    this.upc = upc;
  }

  @Basic
  @Column(name = "selling_price")
  public Long getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Long sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  @Basic
  @Column(name = "products_number")
  public Long getProductsNumber() {
    return productsNumber;
  }

  public void setProductsNumber(Long productsNumber) {
    this.productsNumber = productsNumber;
  }

  @Basic
  @Column(name = "promotional_product")
  public Boolean getPromotionalProduct() {
    return promotionalProduct;
  }

  public void setPromotionalProduct(Boolean promotionalProduct) {
    this.promotionalProduct = promotionalProduct;
  }

  @Basic
  @Column(name = "id_product")
  public Long getProduct() {
    return product;
  }

  public void setProduct(Long product) {
    this.product = product;
  }

  @Basic
  @Column(name = "upc_prom")
  public Long getStoreProductChild() {
    return storeProductChild;
  }

  public void setStoreProductChild(Long storeProductChild) {
    this.storeProductChild = storeProductChild;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StoreProduct that = (StoreProduct) o;
    return Objects.equals(upc, that.upc) && Objects.equals(sellingPrice, that.sellingPrice) && Objects.equals(productsNumber, that.productsNumber) && Objects.equals(promotionalProduct, that.promotionalProduct) && Objects.equals(product, that.product) && Objects.equals(storeProductChild, that.storeProductChild);
  }

  @Override
  public int hashCode() {
    return Objects.hash(upc, sellingPrice, productsNumber, promotionalProduct, product, storeProductChild);
  }
}
