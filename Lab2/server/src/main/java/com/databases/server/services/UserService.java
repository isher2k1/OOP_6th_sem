package com.databases.server.services;

import com.databases.server.entities.User;
import com.databases.server.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
  UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public String getRole(String userId) {
    return this.repository.getUserRole(userId);
  }

  public User findUserById(String id) {
    Optional<User> userOptional = repository.findById(id);
    return userOptional.orElse(null);
  }

  @Transactional
  public void save(User user) {
    Optional<User> userOptional = repository.findByUserId(user.getUserId());
    if (userOptional.isEmpty()) {
      user.setPassword( /*crypt needed*/
        user.getPassword());
      repository.save(user.getUserId(), user.getPassword());
    }
  }
}
