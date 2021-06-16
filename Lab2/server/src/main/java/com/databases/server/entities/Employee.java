package com.databases.server.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Employee {
    private String idEmployee;
    private String emplSurname;
    private String emplName;
    private String emplPatronymic;
    private String role;
    private BigDecimal salary;
    private Date dateOfBirth;
    private Date dateOfStart;
    private String phoneNumber;
    private String city;
    private String street;
    private String zipCode;

    @Id
    @Column(name = "id_employee")
    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Basic
    @Column(name = "empl_surname")
    public String getEmplSurname() {
        return emplSurname;
    }

    public void setEmplSurname(String emplSurname) {
        this.emplSurname = emplSurname;
    }

    @Basic
    @Column(name = "empl_name")
    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }

    @Basic
    @Column(name = "empl_patronymic")
    public String getEmplPatronymic() {
        return emplPatronymic;
    }

    public void setEmplPatronymic(String emplPatronymic) {
        this.emplPatronymic = emplPatronymic;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "date_of_start")
    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(idEmployee, employee.idEmployee) && Objects.equals(emplSurname, employee.emplSurname) && Objects.equals(emplName, employee.emplName) && Objects.equals(emplPatronymic, employee.emplPatronymic) && Objects.equals(role, employee.role) && Objects.equals(salary, employee.salary) && Objects.equals(dateOfBirth, employee.dateOfBirth) && Objects.equals(dateOfStart, employee.dateOfStart) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(city, employee.city) && Objects.equals(street, employee.street) && Objects.equals(zipCode, employee.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployee, emplSurname, emplName, emplPatronymic, role, salary, dateOfBirth, dateOfStart, phoneNumber, city, street, zipCode);
    }
}
