package com.example.Team25SpringMongoRest.repository;

import com.example.Team25SpringMongoRest.model.profile.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface userRepository extends MongoRepository<user, String>{

  @Query("{'username':?0}")
  Optional<user> findByUsername(String username);
}