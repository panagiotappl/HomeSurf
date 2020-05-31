package io.home.surf.controller;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.home.surf.model.UserAccount;
import io.home.surf.model.dto.UserLoginResponse;
import io.home.surf.service.UserService;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<?> findById(@PathVariable UUID id) {
    Optional<UserAccount> userAccount = userService.findById(id);
    if (userAccount.isPresent()) {
      UserLoginResponse response = modelMapper.map(userAccount.get(), UserLoginResponse.class);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
      return new ResponseEntity<>("No user found with id " + id.toString(), HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/username-exists/{username}")
  @ResponseBody
  public ResponseEntity<Boolean> usernameExists(@PathVariable String username) {
    return new ResponseEntity<>(userService.usernameExists(username), HttpStatus.OK);
  }

  @GetMapping("/email-exists/{email}")
  @ResponseBody
  public ResponseEntity<Boolean> emailExists(@PathVariable String email) {
    return new ResponseEntity<>(userService.emailExists(email), HttpStatus.OK);
  }

}
