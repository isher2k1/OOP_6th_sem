package com.databases.server.repositories;

import com.databases.server.entities.Sale;
import com.databases.server.entities.StoreProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreProductRepository extends CrudRepository<StoreProduct, String> {

  @Query(value = "SELECT * FROM store_product", nativeQuery = true)
  List<StoreProduct> findAll();
  //  Скласти список товарів у магазині, що належать певному товару
  @Query(value = "SELECT sp FROM store_product sp WHERE sp.id_product = :productId", nativeQuery = true)
  List<StoreProduct> findAllByProduct(@Param("productId") int productId);

  //За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару.
  @Query(value = "SELECT * " +
    "FROM store_product sp " +
    "WHERE sp.upc = :upc", nativeQuery = true)
  Optional<StoreProduct> findByUpc(@Param("upc") String upc);

  @Modifying
  @Query(value = "update store_product set upc_prom = :upc_prom, id_product = :id_product, selling_price = :selling_price, products_number = :products_number, promotional_product = :promotional_product " +
    "WHERE upc=:upc ", nativeQuery = true)
  void update(@Param("upc") String upc,@Param("upc_prom") String upc_prom,@Param("id_product") Integer id_product,@Param("selling_price") Double selling_price, @Param("products_number") Integer products_number,@Param("promotional_product") Boolean promotional_product);
  //
  @Modifying
  @Query(
    value = "insert into store_product (upc, upc_prom, id_product, selling_price, products_number, promotional_product) " +
      "values (:upc, :upc_prom, :id_product, :selling_price, :products_number, :promotional_product)",
    nativeQuery = true)
  void insert(@Param("upc") String upc,@Param("upc_prom") String upc_prom,@Param("id_product") Integer id_product,@Param("selling_price") Double selling_price, @Param("products_number") Integer products_number,@Param("promotional_product") Boolean promotional_product);
  //    String upc,String upc_prom,Integer id_product, Double selling_price,Integer products_number,Boolean promotional_product
  @Modifying
  @Query(value = "delete from store_product where upc=:upc ", nativeQuery = true)
  void delete(@Param("upc") String upc);
}
