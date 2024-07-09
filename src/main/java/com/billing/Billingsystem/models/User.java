package com.billing.Billingsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "users")
public class User {
  @Id
  private String id;
  @Indexed
  @NonNull
  private String username;
  @NonNull
  private String password;
  private List<String> roles;

}
