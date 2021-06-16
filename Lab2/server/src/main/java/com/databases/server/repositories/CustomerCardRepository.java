package com.databases.server.repositories;

import com.databases.server.entities.CustomerCard;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerCardRepository extends CrudRepository<CustomerCard, String> {

  @Query(value = "SELECT * FROM customer_card", nativeQuery = true)
  List<CustomerCard> findAll();

  @Query(value = "SELECT * " +
    "FROM customer_card " +
    "WHERE cust_surname = :surname", nativeQuery = true)
  List<CustomerCard> findCustomerCardBySurname(@Param("surname") String surname);

  //Скласти список усіх постійних клієнтів, що мають карту клієнта, по полях  ПІБ, телефон, адреса (якщо вказана)
  @Query(value = "SELECT * " +
    "FROM customer_card " +
    "WHERE street = :street", nativeQuery = true)
  List<CustomerCard> findCustomerCardByStreet(@Param("street") String street);

  @Query(value = "SELECT * " +
    "FROM customer_card " +
    "WHERE phone_number = :phoneNumber", nativeQuery = true)
  List<CustomerCard> findCustomerCardByPhoneNumber(@Param("phoneNumber") String phoneNumber);

  @Query(value = "SELECT * " +
    "FROM customer_card " +
    "WHERE cust_name = :firstname and cust_surname = :surname and cust_patronymic = :patronymic", nativeQuery = true)
  List<CustomerCard> findCustomerCardByPIB(@Param("firstname") String firstname, @Param("surname") String surname, @Param("patronymic") String patronymic);

  @Query(value = "SELECT * " +
    "FROM customer_card " +
    "WHERE percent = :percent", nativeQuery = true)
  List<CustomerCard> findCustomerCardWithPercentage(@Param("percent") int percent);

  @Modifying
  @Query(value = "update customer_card set cust_name = :cust_name, cust_surname = :cust_surname, cust_patronymic = :cust_patronymic, phone_number = :phone_number, city = :city, street = :street, zip_code = :zip_code, percent = :percent " +
    "WHERE card_number = :card_number", nativeQuery = true)
  void update(@Param("card_number") String card_number,@Param("cust_name") String cust_name,@Param("cust_surname") String cust_surname, @Param("cust_patronymic") String cust_patronymic,@Param("phone_number") String phone_number,@Param("city") String city,@Param("street") String street,@Param("zip_code") String zip_code,@Param("percent") Integer percent);

  @Modifying
  @Query(
    value = "insert into customer_card (card_number, cust_name, cust_surname, cust_patronymic, phone_number, city, street, zip_code,\n" +
      "                           percent) " +
      "values (:card_number, :cust_name, :cust_surname, :cust_patronymic, :phone_number, :city, :street, :zip_code,:percent)",
    nativeQuery = true)
  void insert(@Param("card_number") String card_number,@Param("cust_name") String cust_name,@Param("cust_surname") String cust_surname, @Param("cust_patronymic") String cust_patronymic,@Param("phone_number") String phone_number,@Param("city") String city,@Param("street") String street,@Param("zip_code") String zip_code,@Param("percent") Integer percent);

  @Modifying
  @Query(value = "delete from customer_card where card_number=:card_number", nativeQuery = true)
  void delete(@Param("card_number") String card_number);

}
