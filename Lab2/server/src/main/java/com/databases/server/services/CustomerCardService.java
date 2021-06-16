package com.databases.server.services;

import com.databases.server.entities.Category;
import com.databases.server.entities.CustomerCard;
import com.databases.server.repositories.CustomerCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCardService {
  private final CustomerCardRepository customerCardRepository;

  public CustomerCardService(CustomerCardRepository employeeRepository) {
    this.customerCardRepository = employeeRepository;
  }

  public List<CustomerCard> findCustomerCardBySurname(String surname) {
    return this.customerCardRepository.findCustomerCardBySurname(surname);
  }

  public List<CustomerCard> findCustomerCardByStreet(String street) {
    return this.customerCardRepository.findCustomerCardByStreet(street);
  }

  public List<CustomerCard> findCustomerCardByPhoneNumber(String phoneNumber) {
    return this.customerCardRepository.findCustomerCardByPhoneNumber(phoneNumber);
  }

  public List<CustomerCard> findCustomerCardByPIB(String firstname, String surname, String patronymic) {
    return this.customerCardRepository.findCustomerCardByPIB(firstname, surname, patronymic);
  }

  public List<CustomerCard> findCustomerCardWithPercentage(int percent) {
    return this.customerCardRepository.findCustomerCardWithPercentage(percent);
  }

  public List<CustomerCard> findAll() {
    return this.customerCardRepository.findAll();
  }

  public void update(String card_number, String cust_name, String cust_surname, String cust_patronymic, String phone_number, String city, String street, String zip_code,Integer percent) {
    this.customerCardRepository.update(card_number, cust_name, cust_surname, cust_patronymic, phone_number, city, street, zip_code, percent);
  }

  public void insert(String card_number, String cust_name, String cust_surname, String cust_patronymic, String phone_number, String city, String street, String zip_code,Integer percent) {
    this.customerCardRepository.insert(card_number, cust_name, cust_surname, cust_patronymic, phone_number, city, street, zip_code, percent);
  }

  public void delete(String card_number) {
    this.customerCardRepository.delete(card_number);
  }
}
