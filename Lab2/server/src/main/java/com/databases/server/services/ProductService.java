package com.databases.server.services;

import com.databases.server.entities.Product;
import com.databases.server.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAll() {
    return this.productRepository.findAll();
  }

  public List<Product> findAllByCategory(Integer categoryNumber) {
    return this.productRepository.findAllByCategory(categoryNumber);
  }

  public List<Product> findAllByCategoriesOrderByName(Integer categoryNumber) {
    return this.productRepository.findAllByCategoriesOrderByName(categoryNumber);
  }

  public List<Product> findAllOrderByName() {
    return this.productRepository.findAllOrderByName();
  }

  public List<Product> findPromotionalProductsOrderByAmount() {
    return this.productRepository.findPromotionalProductsOrderByAmount();
  }

  public List<Product> findPromotionalProductsOrderByName() {
    return this.productRepository.findPromotionalProductsOrderByName();
  }

  public List<Product> findNotPromotionalProductsOrderByAmount() {
    return this.productRepository.findNotPromotionalProductsOrderByAmount();
  }

  public List<Product> findNotPromotionalProductsOrderByName() {
    return this.productRepository.findNotPromotionalProductsOrderByName();
  }

  public List<Product> findAllByCheckNumber(int checkNumber) {
    return this.productRepository.findAllByCheckNumber(checkNumber);
  }

  public Product findByUpc(String upc) {
    return this.productRepository.findByUpc(upc).orElse(null);
  }

  public void update(Integer id_product,Integer category_number,String product_name,String characteristics) {
    this.productRepository.update(id_product, category_number, product_name, characteristics);
  }

  public void insert(Integer id_product,Integer category_number,String product_name,String characteristics) {
    this.productRepository.insert(id_product, category_number, product_name, characteristics);
  }

  public void delete(Integer id_product) {
    this.productRepository.delete(id_product);
  }

}
