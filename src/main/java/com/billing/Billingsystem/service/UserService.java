package com.billing.Billingsystem.service;

import com.billing.Billingsystem.models.User;

import java.util.List;

public interface UserService {
  List<User> getAllUsers();

  void saveEntry(User user);

  User findByUserName(String userName);

  void deleteByUserName(String userName);

}
