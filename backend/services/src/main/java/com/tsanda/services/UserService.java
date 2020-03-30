package com.tsanda.services;

import com.tsanda.dao.UserRepository;
import com.tsanda.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private static final Logger logger = LogManager.getLogger();
  @Autowired private UserRepository userRepository;

  public List<User> getAllUsers() {
    logger.debug("Getting all users...");
    List<User> userList = userRepository.findAll();
    return userList;
  }

  public User getUserById(Integer id) {
    logger.debug("Getting user by id...");
    return userRepository.findById(id).get();
  }

  public User addUser(User user) {
    logger.debug("Saving new user...");
    return userRepository.saveAndFlush(user);
  }

  public User updateUser(User user, Integer id) {
    logger.debug("Updating user...");
    if (userRepository.existsById(id)) {
      logger.debug("User with id = " + id + " has been updated.");
      user.setId(id);
      return userRepository.saveAndFlush(user);
    } else {
      logger.warn("User with id = " + id + " not found.");
      return null;
    }
  }

  public void deleteUserById(Integer id) {
    logger.debug("Deleting user by id...");
    if (userRepository.existsById(id)) {
      logger.debug("User with id = " + id + " has been deleted.");
      userRepository.deleteById(id);
    }  else {
      logger.warn("User with id = " + id + " not found.");
    }
  }
}
