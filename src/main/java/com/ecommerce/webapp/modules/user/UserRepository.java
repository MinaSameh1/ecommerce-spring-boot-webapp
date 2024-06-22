package com.ecommerce.webapp.modules.user;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

  @Query(value = "{ 'email' : ?0 }", fields = "{ 'email' : 1, 'password' : 1, 'role' : 1, 'name' : 1, 'id' : 1, 'phone': 1}")
  User findByEmail(String email);

  @Query(value = "{ 'name' : ?0 }", fields = "{ 'email' : 1, 'password' : 1, 'role' : 1, 'name' : 1, 'id' : 1, 'phone': 1}")
  List<User> searchByName(String name);
}
