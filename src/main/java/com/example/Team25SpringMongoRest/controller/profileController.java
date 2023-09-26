package com.example.Team25SpringMongoRest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Team25SpringMongoRest.ProfileManagement.profile;
import com.example.Team25SpringMongoRest.exception.profileCollectionException;
import com.example.Team25SpringMongoRest.service.profileService;

import jakarta.validation.ConstraintViolationException;

@RestController

public class profileController{

    @Autowired
    private profileService profileService;

    @RequestMapping(method = RequestMethod.POST, value ="/profile")
    public ResponseEntity<String> createProfile(@RequestBody profile profile){
        try{
            profileService.createProfile(profile);
            return new ResponseEntity<String>("Successfully added " + profile.getUsername(), HttpStatus.OK);
        }catch(ConstraintViolationException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }catch(profileCollectionException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    public ResponseEntity<List<profile>> getAllProfiles(){
        List<profile> profiles = profileService.getAllProfiles();
        return new ResponseEntity<List<profile>>(profiles, profiles.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }



}