package com.billing.Billingsystem.serviceImpl;

import com.billing.Billingsystem.models.User;
import com.billing.Billingsystem.repository.UserRepository;
import com.billing.Billingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  private static final PasswordEncoder  passEncoder = new BCryptPasswordEncoder();

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public void saveEntry(User user) {
    user.setPassword(passEncoder.encode(user.getPassword()));
    userRepository.save(user);
  }



  @Override
  public User findByUserName(String userName) {
    return userRepository.findByUsername(userName);
  }

  @Override
  public void deleteByUserName(String userName) {
    userRepository.deleteByUsername(userName);
  }
}
