package com.billing.Billingsystem.repository;

import com.billing.Billingsystem.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
  User findByUsername(String userName);
}
