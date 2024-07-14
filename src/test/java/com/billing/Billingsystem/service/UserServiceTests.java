package com.billing.Billingsystem.service;

import com.billing.Billingsystem.models.User;
import com.billing.Billingsystem.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
//Helps in creating and generating dependencies
public class UserServiceTests {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userservice;

//  @BeforeEach
//  void setUp() {
//
//  }




  @Disabled
  @Test
  public void add() {
    assertEquals(4,2+2, "Test EXECUTED");
  }

  @Test
  @ArgumentsSource(UserArgumentsProvider.class)
  public void testFindByUserName(String name) {
    User user = userRepository.findByUsername(name);
    assertEquals(4,2+2);
    assertTrue(!user.getRoles().isEmpty());
    assertNotNull(user);
  }

  @ParameterizedTest
  @CsvSource({
    "1,1,2",
    "2,10,12",
    "3,6,9"
  })
  public void test(int a, int b, int expected) {
    assertEquals(expected, a+b,"Test for a = "+a+ " b = "+b+" expected = "+expected);
  }

}
