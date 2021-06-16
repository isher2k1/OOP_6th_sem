package com.databases.server.repositories;

import com.databases.server.entities.Check;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CheckRepository extends CrudRepository<Check, String> {

  @Query(value = "SELECT * FROM \"check\"", nativeQuery = true)
  List<Check> findAll();

  @Query(value = "SELECT * FROM \"check\" WHERE check_number = :checkNumber", nativeQuery = true)
  Optional<Check> findByCheckNumber(@Param("checkNumber") String checkNumber);

  //Загальна сума проданих товарів з чеків, видрукуваних усіма касиром за певний період часу;
  @Query(value = "SELECT SUM(s.product_number)" +
    "FROM ((\"check\" c LEFT JOIN sale s on c.check_number = s.check_number)" +
    "LEFT JOIN store_product sp ON sp.upc = s.upc)" +
    "LEFT JOIN product p ON p.id_product = sp.id_product " +
    "WHERE c.print_date BETWEEN :start AND :end", nativeQuery = true)
  int amountOfAllProductFromCheckByAllCashiersInPeriod(@Param("start") String start, @Param("end") String end);

  //Загальна сума проданих товарів з чеків, видрукуваних певним касиром за певний період часу;
  @Query(value = "SELECT SUM(s.product_number)" +
    "FROM ((\"check\" c LEFT JOIN sale s on c.check_number = s.check_number)" +
    "LEFT JOIN store_product sp ON sp.upc = s.upc)" +
    "LEFT JOIN product p ON p.id_product = sp.id_product " +
    "WHERE c.id_employee = :emplId AND c.print_date BETWEEN :start AND :end", nativeQuery = true)
  int amountOfAllProductFromCheckByCashierInPeriod(@Param("emplId") String emplId, @Param("start") String start, @Param("end") String end);

  // Визначити загальну кількість одиниць певного товару, проданого за певний період часу;
  @Query(value = "SELECT SUM(s.product_number)" +
    "FROM ((\"check\" c LEFT JOIN sale s on c.check_number = s.check_number)" +
    "LEFT JOIN store_product sp ON sp.upc = s.upc)" +
    "LEFT JOIN product p ON p.id_product = sp.id_product " +
    "WHERE p.id_product = :productId AND c.print_date BETWEEN :start AND :end", nativeQuery = true)
  int amountOfAllProductFromCheckByProductIDInPeriod(@Param("productId") String productId, @Param("start") String start, @Param("end") String end);

  @Query(value = "SELECT DISTINCT *" +
    "FROM \"check\" " +
    "WHERE print_date BETWEEN :start AND :end", nativeQuery = true)
  List<Check> findAllPrintedByAllCashiersInPeriod(@Param("start") String start, @Param("end") String end);

  @Query(value = "SELECT *" +
    "FROM \"check\"  " +
    "WHERE id_employee = :emplId " +
    "AND print_date BETWEEN :start AND :end", nativeQuery = true)
  List<Check> findAllPrintedByCashierInPeriod(@Param("emplId") String emplId, @Param("start") String start, @Param("end") String end);

  @Modifying
  @Query(value = "update \"check\" set id_employee = :id_employee, card_number = :card_number, print_date = :print_date, sum_total = :sum_total, vat = :vat where check_number = :check_number", nativeQuery = true)
  void update(@Param("check_number") String check_number, @Param("id_employee") String id_employee, @Param("card_number") String card_number, @Param("print_date") String print_date, @Param("sum_total") Double sum_total, @Param("vat") Double vat);

  @Modifying
  @Query(
    value = "insert into \"check\" (check_number, id_employee, card_number, print_date, sum_total, vat) " +
      "values (:check_number, :id_employee, :card_number, :print_date, :sum_total, :vat)",
    nativeQuery = true)
  void insert(@Param("check_number") String check_number, @Param("id_employee") String id_employee, @Param("card_number") String card_number, @Param("print_date") String print_date, @Param("sum_total") Double sum_total, @Param("vat") Double vat);

  @Modifying
  @Query(value = "delete from \"check\" where check_number=:check_number", nativeQuery = true)
  void delete(@Param("check_number") String check_number);
}
