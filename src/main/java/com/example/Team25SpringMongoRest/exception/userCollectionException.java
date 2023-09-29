package com.example.Team25SpringMongoRest.exception;

public class userCollectionException extends Exception{
  

  public userCollectionException(String message){
    super(message);
  }

  public static String NotFoundException(String id){
    return "Username with " + id + "not found";
  }

  public static String usernameAlreadyExists(){
    return "username already exists";
  }
}
