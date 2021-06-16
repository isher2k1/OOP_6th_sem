package com.databases.server.services;

import com.databases.server.entities.Check;
import com.databases.server.repositories.CheckRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckService {
  private final CheckRepository checkRepository;

  public CheckService(CheckRepository checkRepository) {
    this.checkRepository = checkRepository;
  }

  public Check findByCheckNumber(String checkNumber) {
    return this.checkRepository.findByCheckNumber(checkNumber).orElse(null);
  }

  public List<Check> findAll() {
    return this.checkRepository.findAll();
  }

  public List<Check> findAllPrintedByAllCashiersInPeriod(String start, String end) {
    return this.checkRepository.findAllPrintedByAllCashiersInPeriod(start, end);
  }

  public List<Check> findAllPrintedByCashierInPeriod(String emplId, String start, String end) {
    return this.checkRepository.findAllPrintedByCashierInPeriod(emplId, start, end);
  }

  public int amountOfAllProductFromCheckByAllCashiersInPeriod(String start, String end) {
    return this.checkRepository.amountOfAllProductFromCheckByAllCashiersInPeriod(start, end);
  }

  public int amountOfAllProductFromCheckByCashierInPeriod(String emplId, String start, String end) {
    return this.checkRepository.amountOfAllProductFromCheckByCashierInPeriod(emplId, start, end);
  }

  public int amountOfAllProductFromCheckByProductIDInPeriod(String productId, String start, String end) {
    return this.checkRepository.amountOfAllProductFromCheckByProductIDInPeriod(productId, start, end);
  }

  public void update(String check_number, String id_employee, String card_number, String print_date, Double sum_total, Double vat) {
    this.checkRepository.update(check_number, id_employee, card_number, print_date, sum_total, vat);
  }

  public void insert(String check_number, String id_employee, String card_number, String print_date, Double sum_total, Double vat) {
    this.checkRepository.insert(check_number, id_employee, card_number, print_date, sum_total, vat);
  }

  public void delete(String check_number) {
    this.checkRepository.delete(check_number);
  }
}
