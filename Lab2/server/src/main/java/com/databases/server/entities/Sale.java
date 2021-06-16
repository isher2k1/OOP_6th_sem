package com.databases.server.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "Sale")
@Table(name = "sale")
public class Sale {

  @EmbeddedId
  private SalePK salePK;

  private Long productNumber;
  private Long sellingPrice;

  public SalePK getSalePK() {
    return salePK;
  }

  public void setSalePK(SalePK salePK) {
    this.salePK = salePK;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Sale sale = (Sale) o;
    return Objects.equals(salePK, sale.salePK) && Objects.equals(productNumber, sale.productNumber) && Objects.equals(sellingPrice, sale.sellingPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(salePK, productNumber, sellingPrice);
  }

  @Basic
  @Column(name = "product_number")
  public Long getProductNumber() {
    return productNumber;
  }

  public void setProductNumber(Long productNumber) {
    this.productNumber = productNumber;
  }

  @Basic
  @Column(name = "selling_price")
  public Long getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Long sellingPrice) {
    this.sellingPrice = sellingPrice;
  }
}
