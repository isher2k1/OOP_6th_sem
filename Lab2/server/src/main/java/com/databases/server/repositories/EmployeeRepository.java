package com.databases.server.repositories;

import com.databases.server.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

  @Query(value = "SELECT * FROM employee", nativeQuery = true)
  List<Employee> findAll();

  @Query(value = "SELECT e FROM employee e WHERE e.role = 'Касир' ORDER BY e.empl_surname", nativeQuery = true)
  List<Employee> findAllCashiersOrderByName();

  // -	За прізвищем працівника знайти його телефон та адресу (працівника);
  @Query(value = "SELECT * FROM employee e WHERE e.empl_surname = :surname ORDER BY e.empl_surname", nativeQuery = true)
  List<Employee> findEmployeeBySurname(@Param("surname") String surname);

  //За ID_працівника знайти всю інформацію про себе.
  @Query(value = "SELECT * FROM employee e WHERE e.id_employee = :employeeId", nativeQuery = true)
  Optional<Employee> findEmployeeByEmployeeId(@Param("employeeId") String employeeId);

  @Modifying
  @Query(value = "update employee set empl_surname = :empl_surname, empl_name = :empl_name, empl_patronymic = :empl_patronymic, role = :role, salary = :salary, date_of_birth = :date_of_birth, date_of_start = :date_of_start, phone_number = :phone_number, city = :city, street = :street, zip_code = :zip_code " +
    "WHERE id_employee = :id_employee", nativeQuery = true)
  void update(@Param("id_employee") String id_employee,@Param("empl_surname") String empl_surname,@Param("empl_name") String empl_name,@Param("empl_patronymic") String empl_patronymic,@Param("role") String role,@Param("salary") Double salary,@Param("date_of_birth") String date_of_birth,@Param("date_of_start") String date_of_start,@Param("phone_number") String phone_number,@Param("city") String city,@Param("street") String street, @Param("zip_code")String zip_code);

  @Modifying
  @Query(
    value = "insert into employee (id_employee, empl_surname, empl_name, empl_patronymic, role, salary, date_of_birth, date_of_start,\n" +
      "                      phone_number, city, street, zip_code)\n" +
      "values ()",
    nativeQuery = true)
  void insert(@Param("id_employee") String id_employee,@Param("empl_surname") String empl_surname,@Param("empl_name") String empl_name,@Param("empl_patronymic") String empl_patronymic,@Param("role") String role,@Param("salary") Double salary,@Param("date_of_birth") String date_of_birth,@Param("date_of_start") String date_of_start,@Param("phone_number") String phone_number,@Param("city") String city,@Param("street") String street, @Param("zip_code")String zip_code);

  @Modifying
  @Query(value = "delete from employee where id_employee=:id_employee", nativeQuery = true)
  void delete(@Param("id_employee") String card_number);

}
