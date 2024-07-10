package com.billing.Billingsystem.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

  public User(String username, String password, List<String> roles) {
    this.username = username;
    this.password = password;
    this.roles = roles;
  }

}
