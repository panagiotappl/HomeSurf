package io.home.surf.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.home.surf.exception.HomeSurfApiException;
import io.home.surf.model.UserAccount;
import io.home.surf.model.dto.UserLoginDto;
import io.home.surf.model.dto.UserLoginResponse;
import io.home.surf.model.dto.UserRegisterDto;
import io.home.surf.security.UserTokenService;
import io.home.surf.service.UserService;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@RestController
@RequestMapping("/auth/users")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserTokenService userTokenService;

  @Autowired
  private UserService userService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping("/register")
  @ResponseBody
  public ResponseEntity<?> register(@RequestBody UserRegisterDto registerDto) {
    try {
      UserAccount userAccount = modelMapper.map(registerDto, UserAccount.class);
      userAccount = userService.save(userAccount);
      UserLoginResponse response = modelMapper.map(userAccount, UserLoginResponse.class);
      String token = authenticate(userAccount.getUsername(), registerDto.getPassword());
      response.setToken(token);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (HomeSurfApiException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
  }

  @PostMapping("/login")
  @ResponseBody
  public ResponseEntity<?> logIn(@RequestBody UserLoginDto loginDto) {
    Optional<UserAccount> userAccount = userService.logIn(loginDto.getEmailOrUsername());
    if (userAccount.isPresent()) {
      try {
        UserLoginResponse response = modelMapper.map(userAccount.get(), UserLoginResponse.class);
        String token = authenticate(userAccount.get().getUsername(), loginDto.getPassword());
        response.setToken(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
      } catch (Exception e) {
      }
    }
    return new ResponseEntity<>("Wrong username/email or password", HttpStatus.NOT_FOUND);
  }

  private String authenticate(String username, String password) {
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(username, password));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    return userTokenService.generate(authentication);
  }

}
