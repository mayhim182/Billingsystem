package com.billing.Billingsystem.controller;


import com.billing.Billingsystem.models.User;
import com.billing.Billingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping
  public List<User> getAllUsers(){
    return userService.getAllUsers();
  }

  @PostMapping
  public void createUser(@RequestBody User user) {
    userService.saveEntry(user);
  }

  @PutMapping("/{userName}")
  public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName) {
    User userInDb = userService.findByUserName(userName);
    if(userInDb != null) {
      userInDb.setUsername(user.getUsername());
      userInDb.setPassword(user.getPassword());
      userService.saveEntry(userInDb);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
