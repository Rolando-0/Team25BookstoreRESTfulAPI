package com.example.Team25SpringMongoRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.Team25SpringMongoRest.model.payment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Team25SpringMongoRest.model.user;
import com.example.Team25SpringMongoRest.exception.userCollectionException;
import com.example.Team25SpringMongoRest.repository.userRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class userService {
  
    @Autowired
    private userRepository userRepository;

    public void createUser(user user) throws ConstraintViolationException, userCollectionException{
      
      Optional<user> usernameOptional = userRepository.findByUsername(user.getUsername());
        System.out.println(user.getUsername() + " id: " + user.getId() );
      if(usernameOptional.isPresent()){
        System.out.println(usernameOptional.get());
        throw new userCollectionException(userCollectionException.usernameAlreadyExists());
      }
      else{
          userRepository.save(user);
         }


    }

    public List<user> getAllUsers(){
      List<user> users = userRepository.findAll();

      if(users.size() > 0){
        return users;
      }
      else{
        return new ArrayList<>();
      }
    }

    public user getByUsername(String username) throws userCollectionException{
        Optional<user> usernameOptional = userRepository.findByUsername(username);
        if(!usernameOptional.isPresent()){
            throw new userCollectionException(userCollectionException.NotFoundException(username));
        }
        else{
            return usernameOptional.get();
        }
    }


    public void deleteUserById(String id) throws userCollectionException{
      Optional<user> userOptional = userRepository.findById(id);
      if(!userOptional.isPresent()){
        throw new userCollectionException(userCollectionException.NotFoundException(id));
      } else{
          userRepository.deleteById(id);
      }
    }

    public void updateUser(String username, user newUser) throws ConstraintViolationException, userCollectionException{
        Optional<user> userWithUsername = userRepository.findByUsername(username);
        Optional<user> userWithSameUsername = userRepository.findByUsername(newUser.getUsername());
        if(userWithUsername.isPresent()){
          if(userWithSameUsername.isPresent() && !userWithSameUsername.get().getUsername().equals(username)) {
              throw new userCollectionException(userCollectionException.usernameAlreadyExists());
          }
            user userToUpdate = userWithUsername.get();
            BeanUtils.copyProperties(newUser, userToUpdate);

            userToUpdate.setUsername(username);
            userRepository.save(userToUpdate);
        }
        else{
          throw new userCollectionException(userCollectionException.NotFoundException(username));
        }
    }

    public void addPayment(String username, payment newPayment) throws ConstraintViolationException, userCollectionException{
        Optional<user> userWithUsername = userRepository.findByUsername(username);
        if(userWithUsername.isPresent()){
            user foundUser = userWithUsername.get();
            if(foundUser.getPayments() == null){
                foundUser.setPayments(new ArrayList<payment>());
            }
            foundUser.getPayments().add(newPayment);
            userRepository.save(foundUser);
        }
        else{
            throw new userCollectionException(userCollectionException.NotFoundException(username));
        }
    }
    public List<payment> getUserPayments(String username) throws ConstraintViolationException, userCollectionException{
        Optional<user> userWithUsername = userRepository.findByUsername(username);
        if(userWithUsername.isPresent()){
            user foundUser = userWithUsername.get();
            if(foundUser.getPayments() == null){
                foundUser.setPayments(new ArrayList<payment>());
            }
            return foundUser.getPayments();

        }
        else{
            throw new userCollectionException(userCollectionException.NotFoundException(username));
        }
    }

  }   

  



