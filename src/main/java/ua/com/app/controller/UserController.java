package ua.com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.app.model.Company;
import ua.com.app.model.User;
import ua.com.app.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public ResponseEntity<User> saveNewUser(@RequestBody User user) {
    User newUser = userService.save(user);
    if (newUser != null) {
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
    User userToDelete = userService.getById(id);
    if (userToDelete == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    } else {
      userService.delete(userToDelete);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @RequestMapping(value = "/users/{id}", params = "name", method = RequestMethod.PUT)
  public ResponseEntity<User> updateName(@PathVariable("id") Long id,
      @RequestParam String name) {
    User userToUpdate = userService.getById(id);
    if (userToUpdate == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    } else {
      userService.updateName(userToUpdate, name);
      return ResponseEntity.status(HttpStatus.OK).build();
    }
  }
}
