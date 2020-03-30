package com.tsanda.services;

import com.tsanda.dao.UserRepository;
import com.tsanda.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public List<User> getAllUsers() {
    List<User> userList = userRepository.findAll();
    return userList;
  }

  public User getUserById(Integer id) {
    return userRepository.findById(id).get();
  }

  public User addUser(User user) {
    return userRepository.saveAndFlush(user);
  }

  public User updateUser(User user, Integer id) {
    if (userRepository.existsById(id)) {
      user.setId(id);
      return userRepository.saveAndFlush(user);
    } else {
      return null;
    }
  }

  public void deleteUserById(Integer id) {
    if (userRepository.existsById(id)) {
      userRepository.deleteById(id);
    }
  }
}
