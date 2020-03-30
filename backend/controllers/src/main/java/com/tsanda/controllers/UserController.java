package com.tsanda.controllers;

import com.tsanda.entities.User;
import com.tsanda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

  @Autowired private UserService userService;

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("{id}")
  public User getUserById(@PathVariable Integer id) {
    return userService.getUserById(id);
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.addUser(user);
  }

  @PutMapping("{id}")
  public User updateUser(@RequestBody User user, @PathVariable Integer id) {
    return userService.updateUser(user, id);
  }

  @DeleteMapping("{id}")
  public void deleteUser(@PathVariable Integer id) {
    userService.deleteUserById(id);
  }
}
