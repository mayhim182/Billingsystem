package com.billing.Billingsystem.controller;


import com.billing.Billingsystem.models.User;
import com.billing.Billingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private UserService userService;

  @GetMapping("/allusers")
  public ResponseEntity<?> getAll() {
    List<User> allUsers = userService.getAllUsers();
    if(allUsers!=null && !allUsers.isEmpty()) {
      return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/create-admin-user")
  public void createUser(@RequestBody User user) {
    userService.saveAdmin(user);
  }

}
