package com.example.Team25SpringMongoRest.ProfileManagement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document

public class user {
  
  @Id
  private String id;

  @NotNull(message = "Username cannot be null")
  private String username;

  @NotNull(message = "Password cannot be null")
  private String password;


  private String name;
  private String emailAddress;
  private String homeAddress;

  private List<payment> payments;


}
