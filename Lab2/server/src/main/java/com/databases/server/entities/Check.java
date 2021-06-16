package com.databases.server.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Check {
  private String checkNumber;
  private Date printDate;
  private Long sumTotal;
  private Long vat;
  private String customerCard;
  private String employee;

  @Id
  @Column(name = "check_number")
  public String getCheckNumber() {
    return checkNumber;
  }

  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }

  @Basic
  @Column(name = "print_date")
  public Date getPrintDate() {
    return printDate;
  }

  public void setPrintDate(Date printDate) {
    this.printDate = printDate;
  }

  @Basic
  @Column(name = "sum_total")
  public Long getSumTotal() {
    return sumTotal;
  }

  public void setSumTotal(Long sumTotal) {
    this.sumTotal = sumTotal;
  }

  @Basic
  @Column(name = "vat")
  public Long getVat() {
    return vat;
  }

  public void setVat(Long vat) {
    this.vat = vat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Check check = (Check) o;
    return Objects.equals(checkNumber, check.checkNumber) && Objects.equals(printDate, check.printDate) && Objects.equals(sumTotal, check.sumTotal) && Objects.equals(vat, check.vat) && Objects.equals(employee, check.employee) && Objects.equals(customerCard, check.customerCard);
  }

  @Override
  public int hashCode() {
    return Objects.hash(checkNumber, printDate, sumTotal, vat, employee, customerCard);
  }

  @Basic
  @Column(name = "id_employee")
  public String getEmployee() {
    return employee;
  }

  public void setEmployee(String employee) {
    this.employee = employee;
  }

  @Basic
  @Column(name = "card_number")
  public String getCustomerCard() {
    return customerCard;
  }

  public void setCustomerCard(String customerCard) {
    this.customerCard = customerCard;
  }
}
