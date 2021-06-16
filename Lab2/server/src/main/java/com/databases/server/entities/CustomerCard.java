package com.databases.server.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer_card", schema = "public", catalog = "db")
public class CustomerCard {
    private String cardNumber;
    private String custName;
    private String custSurname;
    private String custPatronymic;
    private String phoneNumber;
    private String city;
    private String street;
    private String zipCode;
    private Integer percent;

    @Id
    @Column(name = "card_number")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Basic
    @Column(name = "cust_surname")
    public String getCustSurname() {
        return custSurname;
    }

    public void setCustSurname(String custSurname) {
        this.custSurname = custSurname;
    }

    @Basic
    @Column(name = "cust_patronymic")
    public String getCustPatronymic() {
        return custPatronymic;
    }

    public void setCustPatronymic(String custPatronymic) {
        this.custPatronymic = custPatronymic;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "percent")
    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerCard that = (CustomerCard) o;
        return Objects.equals(cardNumber, that.cardNumber) && Objects.equals(custName, that.custName) && Objects.equals(custSurname, that.custSurname) && Objects.equals(custPatronymic, that.custPatronymic) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(zipCode, that.zipCode) && Objects.equals(percent, that.percent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, custName, custSurname, custPatronymic, phoneNumber, city, street, zipCode, percent);
    }
}
