package com.databases.server.repositories;

import com.databases.server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
  List<User> findAll();
  Optional<User> findByUserId(String userId);

  @Query(nativeQuery = true, value = "SELECT employee.role " +
                                     "FROM users INNER JOIN employee ON users.user_id = employee.id_employee " +
                                     "WHERE users.user_id = :userId")
  String getUserRole(@Param("userId") String userId);

  @Modifying
  @Query(nativeQuery = true, value = "INSERT INTO public.users(user_id, password) VALUES (:id, :password);")
  void save(@Param("id") String id, @Param("password") String password);
}
