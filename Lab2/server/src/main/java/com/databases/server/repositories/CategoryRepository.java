package com.databases.server.repositories;

import com.databases.server.entities.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public
interface CategoryRepository extends CrudRepository<Category, Long> {
  @Query(value = "SELECT * FROM category ORDER BY category_number", nativeQuery = true)
  List<Category> findAll();
  //-	Скласти список усіх категорій, відсортованих за назвою
  @Query(value = "SELECT * FROM category ORDER BY category.category_name", nativeQuery = true)
  List<Category> findAllSortedByName();

  @Transactional
  @Modifying
  @Query(value = "update category set category_name = :categoryName where category_number = :categoryNumber", nativeQuery = true)
  void update(@Param("categoryNumber") Long categoryNumber, @Param("categoryName") String categoryName);

  @Transactional
  @Modifying
  @Query(
    value = "insert into category (category_number, category_name) " +
      "values (:categoryNumber, :categoryName)",
    nativeQuery = true)
  void insert(@Param("categoryNumber") Long categoryNumber, @Param("categoryName") String categoryName);


  @Transactional
  @Modifying
  @Query(value = "delete from category where category_number=:categoryNumber", nativeQuery = true)
  void delete(@Param("categoryNumber") Long categoryNumber);

}
