package com.proyectoapi.service;

import com.proyectoapi.model.User;
import java.util.Optional;

public interface UserServiceInterface {

  User createUser(User user);

  Optional<User> readUser(Long id);

  User updateUser(Long id, User user);

  Boolean deleteUser(Long id);
}
