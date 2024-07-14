package com.billing.Billingsystem.service;

import com.billing.Billingsystem.models.User;
import com.billing.Billingsystem.repository.UserRepository;
import com.billing.Billingsystem.serviceImpl.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static org.mockito.Mockito.when;


public class UserDetailsServiceImplTests {

  @InjectMocks
  private UserDetailsServiceImpl userDetailsService;

  //Use @MockBean when using @Autowired i.e. playing with spring context
  @Mock
  private UserRepository userRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }


  @Test
  void loadUserByUserNameTest() {
      when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("Mayank")
        .password("encryptedpassword").roles(Arrays.asList(new String[]{"MH370"})).build());
      UserDetails user = userDetailsService.loadUserByUsername("Mayank");
      Assertions.assertNotNull(user);
  }
}
