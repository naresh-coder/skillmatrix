package com.enquero.prowessreef.controller;

import com.enquero.prowessreef.model.User;
import com.enquero.prowessreef.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/user/")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("{user_id}/or/{name}")
  @ResponseBody
  public ResponseEntity<User> getUserDetails(@PathParam("user_id") String userId, @PathParam("name") String name) {
   return new ResponseEntity<>(userService.findUserByUserIdOrFullName(userId, name),HttpStatus.OK);
  }

  @PutMapping("{user_id}")
  public ResponseEntity<String> updateUser(@PathParam("user_id") String userId, @RequestBody User user) {
    return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.OK);
  }


}
