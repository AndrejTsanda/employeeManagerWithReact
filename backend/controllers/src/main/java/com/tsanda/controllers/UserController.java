package com.tsanda.controllers;

import com.tsanda.entities.User;
import com.tsanda.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

  @Autowired private UserService userService;

  @GetMapping
  @ApiOperation(value = "Gets all the users.", produces = "application/json")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED"),
        @ApiResponse(code = 403, message = "FORBIDDEN"),
        @ApiResponse(code = 404, message = "NOT_FOUND")
      })
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("{id}")
  @ApiOperation(
      value = "Finds users by Id.",
      notes = "Provide an Id to look up user from the database.",
      produces = "application/json")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED"),
        @ApiResponse(code = 403, message = "FORBIDDEN"),
        @ApiResponse(code = 404, message = "NOT_FOUND")
      })
  public User getUserById(
      @ApiParam(value = "Id value for the user you need to retrieve.", required = true)
          @PathVariable
          Integer id) {
    return userService.getUserById(id);
  }

  @PostMapping
  @ApiOperation(value = "Create a new User.", produces = "application/json")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 201, message = "CREATED"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED"),
        @ApiResponse(code = 403, message = "FORBIDDEN"),
        @ApiResponse(code = 404, message = "NOT_FOUND")
      })
  public User createUser(@RequestBody User user) {
    return userService.addUser(user);
  }

  @PutMapping("{id}")
  @ApiOperation(value = "Update an existing user by Id.", produces = "application/json")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 201, message = "UPDATED"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED"),
        @ApiResponse(code = 403, message = "FORBIDDEN"),
        @ApiResponse(code = 404, message = "NOT_FOUND")
      })
  public User updateUser(@RequestBody User user, @PathVariable Integer id) {
    return userService.updateUser(user, id);
  }

  @DeleteMapping("{id}")
  @ApiOperation(
      value = "Delete user by Id.",
      notes = "Provide an Id to delete user from the database.",
      produces = "application/json")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "NO_USER"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED"),
        @ApiResponse(code = 403, message = "FORBIDDEN"),
        @ApiResponse(code = 404, message = "NOT_FOUND")
      })
  public void deleteUser(@PathVariable Integer id) {
    userService.deleteUserById(id);
  }
}
