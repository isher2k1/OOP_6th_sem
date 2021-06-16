package com.databases.server.services;

import com.databases.server.entities.Sale;
import com.databases.server.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
  private final SaleRepository saleRepository;

  public SaleService(SaleRepository saleRepository) {
    this.saleRepository = saleRepository;
  }

  public List<Sale> findAll() {
    return this.saleRepository.findAll();
  }

  public void update(String upc, String check_number, Integer product_number, Double selling_price) {
    this.saleRepository.update(upc, check_number, product_number, selling_price);
  }

  public void insert(String upc, String check_number, Integer product_number, Double selling_price) {
    this.saleRepository.insert(upc, check_number, product_number, selling_price);
  }

  public void delete(String upc, String check_number) {
    this.saleRepository.delete(upc, check_number);
  }
}
