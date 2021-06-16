package com.databases.server.repositories;

import com.databases.server.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

  // Скласти список усіх товарів
  @Query(value = "SELECT * " +
    "FROM product", nativeQuery = true)
  List<Product> findAll();

  // Скласти список всіх товарів, що належать певній категорії
  @Query(value = "SELECT p " +
    "FROM product p INNER JOIN category c ON c.category_number = p.category_number " +
    "WHERE c.category_number = :categoryNumber", nativeQuery = true)
  List<Product> findAllByCategory(@Param("categoryNumber") Integer categoryNumber);

  // Скласти список товарів, що належать певній категорії, відсортованих за назвою
  @Query(value = "SELECT p " +
    "FROM product p INNER JOIN category c ON c.category_number = p.category_number " +
    "WHERE c.category_number = :categoryNumber " +
    "ORDER BY p.product_name", nativeQuery = true)
  List<Product> findAllByCategoriesOrderByName(@Param("categoryNumber") Integer categoryNumber);

  //  Скласти список усіх товарів, відсортованих за за назвою

  @Query(value = "SELECT p " +
    "FROM product p " +
    "ORDER BY p.product_name", nativeQuery = true)
  List<Product> findAllOrderByName();

  //  Скласти список усіх акційних товарів,
  //  відсортованих за кількістю одиниць товару/ за назвою

  @Query(value = "SELECT p " +
    "FROM product p INNER JOIN store_product sp on p.id_product = sp.id_product " +
    "WHERE sp.promotional_product = true " +
    "ORDER BY sp.products_number", nativeQuery = true)
  List<Product> findPromotionalProductsOrderByAmount();

  @Query(value = "SELECT p " +
    "FROM product p INNER JOIN store_product sp on p.id_product = sp.id_product " +
    "WHERE sp.promotional_product = true " +
    "ORDER BY p.product_name", nativeQuery = true)
  List<Product> findPromotionalProductsOrderByName();

  //  Скласти список усіх не акційних товарів,
  //  відсортованих за кількістю одиниць товару/ за назвою
  //todo not sure
  @Query(value = "SELECT DISTINCT p " +
    "FROM product p INNER JOIN store_product sp on p.id_product = sp.id_product " +
    "WHERE sp.promotional_product = false " +
    "ORDER BY sp.products_number", nativeQuery = true)
  List<Product> findNotPromotionalProductsOrderByAmount();

  //todo not sure
  @Query(value = "SELECT DISTINCT p " +
    "FROM product p INNER JOIN store_product sp on p.id_product = sp.id_product " +
    "WHERE sp.promotional_product = false " +
    "ORDER BY p.product_name", nativeQuery = true)
  List<Product> findNotPromotionalProductsOrderByName();

  //
  //todo not sure
  //За номером чека скласти список усіх товарів, інформація про продаж яких є у цьому чеку;
  @Query(value = "SELECT p.* " +
    "FROM \"check\" ch " +
    "INNER JOIN sale s on ch.check_number = s.check_number " +
    "INNER JOIN store_product sp ON sp.upc = s.upc " +
    "INNER JOIN product p ON p.id_product = sp.id_product " +
    "WHERE ch.check_number = :checkNumber", nativeQuery = true)
  List<Product> findAllByCheckNumber(@Param("checkNumber") int checkNumber);

  @Query(value = "SELECT p.*" +
    "FROM store_product sp INNER JOIN product p on p.id_product = sp.id_product " +
    "WHERE sp.upc = :upc", nativeQuery = true)
  Optional<Product> findByUpc(@Param("upc") String upc);

  @Modifying
  @Query(value = "update product set category_number = :category_number , product_name = :product_name, characteristics = :characteristics " +
    "WHERE id_product = :id_product", nativeQuery = true)
  void update(@Param("id_product") Integer id_product,@Param("category_number") Integer category_number,@Param("product_name") String product_name,@Param("characteristics") String characteristics);
  //
  @Modifying
  @Query(
    value = "insert into product (id_product, category_number, product_name, characteristics) " +
      "values (:id_product, :category_number, :product_name, :characteristics)",
    nativeQuery = true)
  void insert(@Param("id_product") Integer id_product,@Param("category_number") Integer category_number,@Param("product_name") String product_name,@Param("characteristics") String characteristics);

  @Modifying
  @Query(value = "delete from product where id_product=:id_product", nativeQuery = true)
  void delete(@Param("id_product") Integer id_product);

}
