package com.enquero.prowessreef.service;

import com.enquero.prowessreef.model.User;
import com.enquero.prowessreef.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByUserIdOrFullName(String userId, String name){
        return userRepository.findUserByUserIdOrFullName(userId, name);
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public String updateUser(String userId, User user){
        User oldUser = this.findUserByUserIdOrFullName(userId, "");
        userRepository.save(user);
        //TODO: temp code
        return "success";
    }

    public void removeUser(String userId, String name){
        User user1 = this.findUserByUserIdOrFullName(userId,name);
        userRepository.delete(user1);
    }
}
