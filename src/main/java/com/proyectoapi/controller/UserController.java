package com.proyectoapi.controller;

import com.proyectoapi.model.User;
import com.proyectoapi.service.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  @Autowired
  private final UserServiceInterface userService;

  @PostMapping
  public ResponseEntity createUser(@RequestBody User user) {
    return new ResponseEntity(userService.createUser(user), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity readUser(@PathVariable("id") Long id) {
    return new ResponseEntity(userService.readUser(id), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity updateUser(@PathVariable("id") Long id, @RequestBody User user) {
    return new ResponseEntity(userService.updateUser(id, user), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteUser(@PathVariable("id") Long id) {

    boolean answer = userService.deleteUser(id);

    if (answer == true) {
      return new ResponseEntity(HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
}
