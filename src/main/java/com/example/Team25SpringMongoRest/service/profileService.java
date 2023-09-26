package com.example.Team25SpringMongoRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Team25SpringMongoRest.ProfileManagement.profile;
import com.example.Team25SpringMongoRest.exception.profileCollectionException;
import com.example.Team25SpringMongoRest.repository.profileRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class profileService {
  
    @Autowired
    private profileRepository profileRepository;

    public void createProfile(profile profile) throws ConstraintViolationException, profileCollectionException{
      
      Optional<profile> usernameOptional = profileRepository.findByUsername(profile.getUsername());
        System.out.println(profile.getUsername() + " id: " + profile.getId() );
      if(usernameOptional.isPresent()){
        System.out.println(usernameOptional.get());
        throw new profileCollectionException(profileCollectionException.usernameAlreadyExists());
      }
      else{
        profileRepository.save(profile);
         }


    }

    public List<profile> getAllProfiles(){
      List<profile> profiles = profileRepository.findAll();

      if(profiles.size() > 0){
        return profiles;
      }
      else{
        return new ArrayList<>();
      }
    }

    public void deleteUserById(String id) throws profileCollectionException{
      Optional<profile> profileOptional = profileRepository.findById(id);
      if(!profileOptional.isPresent()){
        throw new profileCollectionException(profileCollectionException.NotFoundException(id));
      } else{
        profileRepository.deleteById(id);
      }
    }

    public void updateProfile(String id, profile newProfile) throws ConstraintViolationException, profileCollectionException{
        Optional<profile> profileWithId = profileRepository.findById(id);
        Optional<profile> profileWithSameUsername = profileRepository.findByUsername(newProfile.getUsername());
        if(profileWithId.isPresent()){
          if(profileWithSameUsername.isPresent() && !profileWithSameUsername.get().getId().equals(id)) {
              throw new profileCollectionException(profileCollectionException.usernameAlreadyExists());
          }
          profile profileToUpdate = profileWithId.get();
          BeanUtils.copyProperties(newProfile, profileToUpdate);

          profileToUpdate.setId(id);
          profileRepository.save(profileToUpdate);
        }
        else{
          throw new profileCollectionException(profileCollectionException.NotFoundException(id));
        }
    }

  }   

  



