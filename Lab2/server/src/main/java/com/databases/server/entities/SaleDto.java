package com.databases.server.entities;

public class SaleDto {

  private String upc;
  private String checkNumber;
  private Long productNumber;
  private Long sellingPrice;

  public SaleDto(Sale sale) {
    this.upc = sale.getSalePK().getUpc();
    this.checkNumber = sale.getSalePK().getCheckNumber();
    this.productNumber = sale.getProductNumber();
    this.sellingPrice = sale.getSellingPrice();
  }

  public String getUpc() {
    return upc;
  }

  public void setUpc(String upc) {
    this.upc = upc;
  }

  public String getCheckNumber() {
    return checkNumber;
  }

  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }

  public Long getProductNumber() {
    return productNumber;
  }

  public void setProductNumber(Long productNumber) {
    this.productNumber = productNumber;
  }

  public Long getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Long sellingPrice) {
    this.sellingPrice = sellingPrice;
  }
}
