package org.example.lesson2.controller;

import lombok.RequiredArgsConstructor;
import org.example.lesson2.db.entity.User;
import org.example.lesson2.db.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/users" )
@RequiredArgsConstructor
public class UserRestController
{
  private final UserRepository userRepository;

  @GetMapping
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  //  @GetMapping( "/{id}" )
  //  public User getUserById(
  //    @PathVariable
  //    int id )
  //  {
  ////    log.info(
  ////      "getUserById() called with id: {}",
  ////      id
  ////    );
  //    return userService.getUserById( id );
  //  }
}
