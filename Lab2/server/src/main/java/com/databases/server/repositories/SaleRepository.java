package com.databases.server.repositories;

import com.databases.server.entities.Category;
import com.databases.server.entities.Product;
import com.databases.server.entities.Sale;
import com.databases.server.entities.SalePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends CrudRepository<Sale, SalePK> {
  @Query(value = "SELECT * FROM sale", nativeQuery = true)
  List<Sale> findAll();

  @Modifying
  @Query(value = "update sale set product_number = :product_number , selling_price = :selling_price " +
    "WHERE upc=:upc AND check_number = :check_number", nativeQuery = true)
  void update(@Param("upc") String upc, @Param("check_number") String check_number, @Param("product_number") Integer product_number, @Param("selling_price") Double selling_price);
  //
  @Modifying
  @Query(
    value = "insert into sale (upc, check_number, product_number, selling_price) " +
      "values (:upc, :check_number, :product_number, :selling_price)",
    nativeQuery = true)
  void insert(@Param("upc") String upc,@Param("check_number") String check_number,@Param("product_number") Integer product_number,@Param("selling_price") Double selling_price);
  //    String upc, String check_number, Integer product_number,Double selling_price
  @Modifying
  @Query(value = "delete from sale where upc=:upc AND check_number = :check_number", nativeQuery = true)
  void delete(@Param("upc") String upc,@Param("check_number") String check_number);
}
