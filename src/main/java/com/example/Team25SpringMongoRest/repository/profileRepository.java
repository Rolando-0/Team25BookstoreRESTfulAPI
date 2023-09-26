package com.example.Team25SpringMongoRest.repository;

import com.example.Team25SpringMongoRest.ProfileManagement.profile;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface profileRepository extends MongoRepository<profile, String>{

  @Query("{'username':?0}")
  Optional<profile> findByUsername(String username);
}