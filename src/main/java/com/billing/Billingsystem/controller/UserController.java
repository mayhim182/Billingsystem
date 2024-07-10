package com.billing.Billingsystem.controller;


import com.billing.Billingsystem.models.User;
import com.billing.Billingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/getAllUsers")
  public List<User> getAllUsers(){
    return userService.getAllUsers();
  }

  @PostMapping("/createUser")
  public void createUser(@RequestBody User user) {
    userService.saveEntry(user);
  }

  @PutMapping("/updateUser")
  public ResponseEntity<?> updateUser(@RequestBody User user) {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userName = authentication.getName();

    User userInDb = userService.findByUserName(userName);
    if(userInDb != null) {
      userInDb.setUsername(user.getUsername());
      userInDb.setPassword(user.getPassword());
      userService.saveEntry(userInDb);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping
  public ResponseEntity<?> deleteUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    userService.deleteByUserName(authentication.getName());
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


}
