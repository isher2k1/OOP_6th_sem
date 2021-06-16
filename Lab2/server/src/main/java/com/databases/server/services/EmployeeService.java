package com.databases.server.services;

import com.databases.server.entities.Category;
import com.databases.server.entities.Employee;
import com.databases.server.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public List<Employee> findAll() {
    return this.employeeRepository.findAll();
  }

  public List<Employee> findAllCashiersOrderByName(){
    return this.employeeRepository.findAllCashiersOrderByName();
  }

  public List<Employee> findEmployeeBySurname(String surname){
    return this.employeeRepository.findEmployeeBySurname(surname);
  }

  public Employee findEmployeeByEmployeeId(String employeeId){
    return this.employeeRepository.findEmployeeByEmployeeId(employeeId).orElse(null);
  }

  public void update(String id_employee,String empl_surname, String empl_name,String empl_patronymic,String role,Double salary,String date_of_birth,String date_of_start,String phone_number, String city,String street, String zip_code) {
    this.employeeRepository.update(id_employee, empl_surname, empl_name, empl_patronymic, role, salary, date_of_birth, date_of_start,phone_number, city, street, zip_code);
  }

  public void insert(String id_employee,String empl_surname, String empl_name,String empl_patronymic,String role,Double salary,String date_of_birth,String date_of_start,String phone_number, String city,String street, String zip_code) {
    this.employeeRepository.insert(id_employee, empl_surname, empl_name, empl_patronymic, role, salary, date_of_birth, date_of_start,phone_number, city, street, zip_code);
  }

  public void delete(String id_employee) {
    this.employeeRepository.delete(id_employee);
  }
}
