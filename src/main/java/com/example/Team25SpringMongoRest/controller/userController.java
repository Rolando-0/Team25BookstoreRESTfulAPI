package com.example.Team25SpringMongoRest.controller;
import java.util.List;
import java.util.Optional;

import com.example.Team25SpringMongoRest.ProfileManagement.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Team25SpringMongoRest.ProfileManagement.user;
import com.example.Team25SpringMongoRest.exception.userCollectionException;
import com.example.Team25SpringMongoRest.service.userService;

import jakarta.validation.ConstraintViolationException;

@RestController

public class userController{

    @Autowired
    private userService userService;

    @RequestMapping(method = RequestMethod.POST, value ="/user")
    public ResponseEntity<String> createUser(@RequestBody user user){ /* CREATE USER (POST) */
        try{
            userService.createUser(user);
            return new ResponseEntity<String>("Successfully added " + user.getUsername(), HttpStatus.OK);
        }catch(ConstraintViolationException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }catch(userCollectionException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public ResponseEntity<List<user>> getAllUsers(){
        List<user> users = userService.getAllUsers();
        return new ResponseEntity<List<user>>(users, users.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{username}") /* GET USER BY USERNAME (GET) */
    public ResponseEntity<user> getByUsername(@PathVariable String username){
        try{
            user foundUser = userService.getByUsername(username);
            return new ResponseEntity<user>(foundUser,HttpStatus.OK);
        }catch(userCollectionException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{username}") /* UPDATE USER (PUT) */
    public ResponseEntity updateByUsername(@PathVariable("username") String username, @RequestBody user newUser) {
        try {
            userService.updateUser(username,newUser);
            return new ResponseEntity("Updated User with username " + username + "", HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (userCollectionException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/payment/{username}") /* ADD PAYMENT FOR USER (POST) */
    public ResponseEntity addPayment(@PathVariable("username") String username, @RequestBody payment newPayment){
        try {
            userService.addPayment(username,newPayment);
            return new ResponseEntity("Added payment for " + username + "", HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (userCollectionException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/payment/{username}")
    public ResponseEntity<List<payment>> getPayments(@PathVariable String username){
        try{
            List<payment> payments = userService.getUserPayments(username);

            return new ResponseEntity<List<payment>>(payments,payments.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        }catch(userCollectionException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }



}