package com.tsanda.services;

import com.tsanda.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService implements UserDetailsService {

  @Autowired private UserRepository userRepository;

  @Autowired private PasswordEncoder bcryptEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    com.tsanda.entities.User user = userRepository.findByUserName(username);

    if (user == null) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }

    return new User(user.getUserName(), user.getUserPassword(), new ArrayList<>());
  }
}
