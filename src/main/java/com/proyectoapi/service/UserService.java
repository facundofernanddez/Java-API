package com.proyectoapi.service;

import com.proyectoapi.model.User;
import com.proyectoapi.repository.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

  private final UserRepository userRepository;

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public Optional<User> readUser(Long id) {
    return userRepository.findById(id);
  }

  @Override
  public User updateUser(Long id, User user) {
    User userWanted = userRepository.findById(id).get();
    userWanted.setAddress(user.getAddress());
    return userRepository.save(userWanted);
  }

  @Override
  public Boolean deleteUser(Long id) {
    try {
      userRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
