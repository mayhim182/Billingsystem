package com.billing.Billingsystem.serviceImpl;

import com.billing.Billingsystem.models.User;
import com.billing.Billingsystem.repository.UserRepository;
import com.billing.Billingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public void saveEntry(User user) {
    userRepository.save(user);
  }



  @Override
  public User findByUserName(String userName) {
    return userRepository.findByUsername(userName);
  }
}
