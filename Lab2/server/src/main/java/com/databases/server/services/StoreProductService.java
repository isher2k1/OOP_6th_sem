package com.databases.server.services;

import com.databases.server.entities.Employee;
import com.databases.server.entities.StoreProduct;
import com.databases.server.repositories.StoreProductRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreProductService {
  private final StoreProductRepository storeProductRepository;

  public StoreProductService(StoreProductRepository storeProductRepository) {
    this.storeProductRepository = storeProductRepository;
  }

  public List<StoreProduct> findAll() {
    return this.storeProductRepository.findAll();
  }

  public List<StoreProduct> findAllByProduct(Integer productId) {
    return this.storeProductRepository.findAllByProduct(productId);
  }

  public StoreProduct findByUpc(@Param("upc") String upc){
    return this.storeProductRepository.findByUpc(upc).orElse(null);
  }

  public void update(String upc,String upc_prom,Integer id_product, Double selling_price,Integer products_number,Boolean promotional_product) {
    this.storeProductRepository.update(upc, upc_prom, id_product, selling_price, products_number, promotional_product);
  }

  public void insert(String upc,String upc_prom,Integer id_product, Double selling_price,Integer products_number,Boolean promotional_product) {
    this.storeProductRepository.insert(upc, upc_prom, id_product, selling_price, products_number, promotional_product);
  }

  public void delete(String upc) {
    this.storeProductRepository.delete(upc);
  }
}
