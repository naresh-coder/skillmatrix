package com.enquero.prowessreef.controller;

import com.enquero.prowessreef.model.User;
import com.enquero.prowessreef.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/admin/")
public class AdminController {


  @Autowired
  UserService userService;

  @PostMapping("create_user")
  public ResponseEntity<Void> createUser(@RequestBody User user) {
    userService.createUser(user);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("{user_id}/or/{name}")
  public ResponseEntity<Void> remove(@PathParam("name") String userId, @PathParam("name") String name) {
    userService.removeUser(name, name);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
