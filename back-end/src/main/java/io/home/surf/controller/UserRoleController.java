package io.home.surf.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.home.surf.model.UserRole;
import io.home.surf.model.dto.UserRoleResponse;
import io.home.surf.service.UserRoleService;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@RestController
@RequestMapping("/user-roles")
public class UserRoleController {

  @Autowired
  private UserRoleService roleService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping
  @ResponseBody
  public ResponseEntity<List<UserRoleResponse>> findAll() {
    List<UserRole> allRoles = roleService.findAll();
    List<UserRoleResponse> responseList = allRoles.stream()
        .map(r -> modelMapper.map(r, UserRoleResponse.class)).collect(Collectors.toList());
    return new ResponseEntity<>(responseList, HttpStatus.OK);
  }

}
